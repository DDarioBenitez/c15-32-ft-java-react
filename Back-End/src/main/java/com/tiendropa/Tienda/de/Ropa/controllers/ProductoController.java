package com.tiendropa.Tienda.de.Ropa.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodsRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.tiendropa.Tienda.de.Ropa.models.Producto;


@RestController
@RequestMapping("/api/producto")
public class ProductoController
{
    @GetMapping("/checkout")
    public ResponseEntity<?> checkout() throws MPException, MPApiException
    {
        Random rand = new Random();

        // Productos de prueba
        List<Producto> productos = new ArrayList<>();
        for(int i = 0; i < rand.nextInt(5) + 1; i++)
        {
            Producto producto = new Producto();
            producto.setNombre("Producto de prueba N#" + i + 1);
            producto.setPrecio(new BigDecimal(rand.nextDouble() * 100.0));
            producto.setTalle("XL");
            producto.setMarca("Anybranch");
            productos.add(producto);
        }

        // Crear pago
        List<PreferenceItemRequest> preferenceItems = new ArrayList<>(); // Lista de items del pago
        for(Producto producto: productos) // Iterar sobre cada producto que va a comprar el usuario
        {
            PreferenceItemRequest preferenceItem =
                PreferenceItemRequest.builder()
                    .id(String.valueOf(producto.getId()))
                    .title(producto.getNombre()) // Nombre del producto
                    .quantity(rand.nextInt(5) + 1) // La cantidad que va a comprar
                    .unitPrice(producto.getPrecio()) // El precio unitario - MercadoPago se encarga de calcular el total
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
        metadata.put("usuario_id", "1"); // (editar)

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
}
