package com.tiendropa.Tienda.de.Ropa.controllers;

import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.preference.Preference;
import com.tiendropa.Tienda.de.Ropa.dtos.NuevaOrdenDTO;
import com.tiendropa.Tienda.de.Ropa.dtos.NuevaOrdenDetalleDTO;
import com.tiendropa.Tienda.de.Ropa.dtos.WebhookNotificationDTO;
import com.tiendropa.Tienda.de.Ropa.models.Orden;
import com.tiendropa.Tienda.de.Ropa.models.OrdenDetalle;
import com.tiendropa.Tienda.de.Ropa.models.Producto;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.OrdenDetalleService;
import com.tiendropa.Tienda.de.Ropa.services.OrdenService;
import com.tiendropa.Tienda.de.Ropa.services.ProductoService;
import com.tiendropa.Tienda.de.Ropa.services.UsuarioService;
import com.tiendropa.Tienda.de.Ropa.utils.Descuento;
import com.tiendropa.Tienda.de.Ropa.utils.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaccion")
public class TransaccionController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private OrdenDetalleService ordenDetalleService;
    @Autowired
    private OrdenService ordenService;


    @GetMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody NuevaOrdenDTO nuevaOrden, Authentication authentication) throws MPException, MPApiException
        {
//            Random rand = new Random();
//
//            // Productos de prueba
//            List<Producto> productos = new ArrayList<>();
//            for(int i = 0; i < rand.nextInt(5) + 1; i++)
//            {
//                Producto producto = new Producto();
//                producto.setNombre("Producto de prueba N#" + i + 1);
//                producto.setPrecio(rand.nextDouble() * 100.0);
//                producto.getTalle().add("XL");
//                producto.setMarca("Anybranch");
//                productos.add(producto);
//            }
            List<Long> productoIds = nuevaOrden.getDetalles().stream().map(NuevaOrdenDetalleDTO::getProductoId).toList();
            List<Producto> productos = productoService.findAllById(productoIds);
            // Crear pago
            List<PreferenceItemRequest> preferenceItems = new ArrayList<>(); // Lista de items del pago
            for(Producto producto: productos) // Iterar sobre cada producto que va a comprar el usuario
            {
                PreferenceItemRequest preferenceItem =
                        PreferenceItemRequest.builder()
                                .id(String.valueOf(producto.getId()))
                                .title(producto.getNombre()) // Nombre del producto
                                .quantity(nuevaOrden.getDetalles().stream().filter(detalle -> detalle.getProductoId() == producto.getId()).findFirst().get().getCantidad()) // La cantidad que va a comprar
                                .unitPrice(BigDecimal.valueOf(producto.getPrecio())) // El precio unitario - MercadoPago se encarga de calcular el total
                                .currencyId("ARS") // La moneda en la que se va a cobrar
                                .build();

                preferenceItems.add(preferenceItem);
            }

            // Lista de tarjetas excluidas
            String[] excludedCards = {"amex", "argencard", "cmr", "cencosud", "cordobesa", "diners", "tarshop"};
            List<PreferencePaymentMethodRequest> excludedPaymentMethods = new ArrayList<>();

            for(String card: excludedCards) {
                excludedPaymentMethods.add(PreferencePaymentMethodRequest.builder().id(card).build());
            }

            // Configurar los back urls
            // Cuando el usuario compre a través de MP, se le va a mostrar un boton que va a redirigir a cierta URL de nuestra página dependiendo del estado del pago
            String baseUrl = "http://localhost:3000"; // URL base de la página

            PreferenceBackUrlsRequest backUrls =
                    PreferenceBackUrlsRequest.builder()
                            .success(baseUrl + "/compras") // Si el pago fue exitoso, mostrará un botón que redirigirá a esta URL
                            .pending(baseUrl + "/compras") // ...
                            .failure(baseUrl + "/carrito")
                            .build();

            // (Configurar metadata )
            // Son datos adicionales que podemos guardar en nuestro preference - guardaremos el producto y la cantidad que compró el usuario
            // Cuando el usuario realice el pago, el Webhook de MP va a devolver un pago_id donde vamos a poder obtener estos datos adicionales
            // Los campos tienen que estar en minuscula y separados por "_" ya que así los devuelve el Webhook (si lo enviamos como productoId se va a cambiar a "producto_id")
            Map<String, Object> metadata = new HashMap<>();
            List<Map<String, Object>> metadataCarrito = new ArrayList<>();

            for(PreferenceItemRequest item: preferenceItems)
            {
                Map<String, Object> metadataItem = new HashMap<>();
                metadataItem.put("producto_id", item.getId());
                metadataItem.put("cantidad", item.getQuantity());
                metadataCarrito.add(metadataItem);
            }

            metadata.put("carrito", metadataCarrito);
            metadata.put("usuario_email", authentication.getName()); // (editar)

            // Construir Preference
            PreferenceRequest preferenceRequest =
                    PreferenceRequest.builder()
                            .paymentMethods(
                                    PreferencePaymentMethodsRequest.builder()
                                            .installments(1) // Cantidad de cuotas
                                            .excludedPaymentMethods(excludedPaymentMethods)
                                            .build()
                            )
                            .items(preferenceItems)
                            .metadata(metadata)
                            .backUrls(backUrls)
                            .build();

            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);


            return ResponseEntity.ok(preference.getId()); // Devolver el "preference_id" creado
        }

    @PostMapping("/mercadopago/webhook")
    public @ResponseBody ResponseEntity<?> webhookNotification(@RequestBody WebhookNotificationDTO request) throws MPException, MPApiException {
        if (request.getType().equals("payment")) {
            Long paymentId = Long.parseLong(request.getData().getId());
            PaymentClient client = new PaymentClient();
            Payment payment = client.get(paymentId);

            if (payment.getStatus().equals("approved")) {
                Map<String, Object> metadata = payment.getMetadata();
                System.out.println(metadata);

                @SuppressWarnings("unchecked")
                List<Map<String, Object>> carritoMetadata = (List<Map<String, Object>>) metadata.get("carrito");

                Orden orden = new Orden();
                ordenService.save(orden);

                Usuario usuario = usuarioService.findByEmail(metadata.get("usuario_email").toString());
                orden.setUsuario(usuario);

                for (Map<String, Object> detalleCarrito : carritoMetadata) {
                    Long productoId = Long.parseLong(detalleCarrito.get("producto_id").toString());
                    int cantidad = Integer.parseInt(detalleCarrito.get("cantidad").toString());

                    Producto producto = productoService.findById(productoId); // Obtener el producto por ID

                    if (producto != null) {
                        OrdenDetalle ordenDetalle = new OrdenDetalle(cantidad, cantidad * producto.getDescuento() >0 ? Descuento.aplicarDescuento(producto.getPrecio(), producto.getDescuento()) : producto.getPrecio());
                        orden.addDetalles(ordenDetalle);
                        producto.setCantidad(producto.getCantidad() - cantidad);
                        productoService.save(producto);
                        ordenDetalleService.save(ordenDetalle);
                    }
                }

                usuario.addOrden(orden);
                usuarioService.save(usuario);
                ordenService.save(orden);
            }
        }
        return ResponseEntity.ok().build();
    }


}
