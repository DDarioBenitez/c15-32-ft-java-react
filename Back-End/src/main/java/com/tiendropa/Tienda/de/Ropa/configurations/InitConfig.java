package com.tiendropa.Tienda.de.Ropa.configurations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

import com.tiendropa.Tienda.de.Ropa.enums.Categoria;
import com.tiendropa.Tienda.de.Ropa.models.Orden;
import com.tiendropa.Tienda.de.Ropa.models.OrdenDetalle;
import com.tiendropa.Tienda.de.Ropa.services.OrdenDetalleService;
import com.tiendropa.Tienda.de.Ropa.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tiendropa.Tienda.de.Ropa.enums.Rol;
import com.tiendropa.Tienda.de.Ropa.models.Producto;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.ProductoService;
import com.tiendropa.Tienda.de.Ropa.services.UsuarioService;

import jakarta.annotation.PostConstruct;



@Component
public class InitConfig 
{
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @Autowired
    private OrdenService ordenService;

    @Autowired
    private PasswordEncoder encoder;


    @PostConstruct
    public void init()
    {
        Producto producto = null;
        OrdenDetalle od = null;
        Orden orden = null;
        Random rand = new Random();

        Usuario cliente = new Usuario();
        cliente.setEmail("cliente@mail.com");
        cliente.setPassword(encoder.encode("123"));
        cliente.setRol(Rol.CLIENT);
        cliente.setNombre("Prueba");
        cliente.setApellido("Prueba");
        usuarioService.save(cliente);

        Usuario admin = new Usuario();
        admin.setEmail("admin@mail.com");
        admin.setPassword(encoder.encode("123"));
        admin.setRol(Rol.ADMIN);
        usuarioService.save(admin);

        orden = new Orden();
        orden.setUsuario(cliente);
        od = new OrdenDetalle();

        producto = new Producto();
        producto.setNombre("Musculosa Crepe Flowns - Off White Mujer Portsaid");
        producto.setDescripcion("Portsaid es la marca argentina orientada a superar las expectativas de una mujer en permanente evolución.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(12);
        producto.setMarca("Portsaid");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_608150-MLA72380528171_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_962922-MLA72380528173_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_900246-MLA72380528175_102023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        producto.setCategoria(Categoria.WOMAN);
        od.setPrecioTotal(producto.getPrecio()*12);
        od.setCantidad(12);
        producto.addDetalle(od);
        orden.setPrecioTotal(producto.getPrecio()*12);
        orden.addDetalles(od);

        ordenService.save(orden);
        productoService.save(producto);
        ordenDetalleService.save(od);


        od = new OrdenDetalle();

        producto = new Producto();
        producto.setNombre("Chomba Vatiare Beige");
        producto.setDescripcion("Chomba de piqué estampado full print, con cuello polo, de calce intermedio.. Composición : 100% Algodón");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Equus");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_600131-MLA51483246856_092022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_997054-MLA51483246859_092022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_822922-MLA51483246854_092022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Beige"));
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        od.setPrecioTotal(producto.getPrecio()*5);
        od.setCantidad(5);
        producto.addDetalle(od);
        orden.setPrecioTotal(orden.getPrecioTotal()+producto.getPrecio()*5);
        orden.addDetalles(od);
        ordenService.save(orden);
        productoService.save(producto);
        ordenDetalleService.save(od);

        od = new OrdenDetalle();

        producto = new Producto();
        producto.setNombre("Camisa Basica Recta Mujer Sweet Portel");
        producto.setDescripcion("Camisa larga corte clásico pero con detalles que la hacen especial. La unión entre su manga y puño tiene terminación de pequeñas pinzas dando efecto de frunce y pequeños pliegues. Tiene bolsillo funcional de lado derecho. Textil: Batista con algodón.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Sweet");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_862731-MLA72204366605_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_640885-MLA72204209867_102023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Rosado"));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        od.setPrecioTotal(producto.getPrecio()*2);
        od.setCantidad(2);
        producto.addDetalle(od);
        orden.setPrecioTotal(orden.getPrecioTotal()+producto.getPrecio()*2);
        orden.addDetalles(od);
        ordenService.save(orden);
        productoService.save(producto);
        ordenDetalleService.save(od);


        producto = new Producto();
        producto.setNombre("Vestido Doha Batik De Mujer 47 Street");
        producto.setDescripcion("BIENVENIDOS A LA TIENDA OFICIAL DE 47STREET");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("47 Street");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_637740-MLA52028206523_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_822093-MLA52028206530_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_860255-MLA52028206522_102022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Celeste"));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Remera Customs O'neill");
        producto.setDescripcion("Tienda oficial O’Neill y Fallen Footwear");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Oneill Argentina");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_686904-MLA51935097446_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_937767-MLA51935097448_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_745780-MLA51935003931_102022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Rosado"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(2));
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Vestido Sun Chasers Billabong Mujer");
        producto.setDescripcion("Este modelo esta creado para que puedas personalizar tu look y combinar estilo y comodidad en tu outfit. El vestido Sun Chasers es un modelo corto cruzado adelante y con mangas bombe, perfecto para que luzcas autentica y fresca. Confeccionado con fibrana estampada, con un diseño delicado y floreado. Enamorate de la originalidad y convertite en tu mejor versión.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Billabong");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_918181-MLA51304792604_082022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_862953-MLA51304858215_082022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_986591-MLA51304848248_082022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Azul"));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Remera De Hombre Th6709 Lacoste");
        producto.setDescripcion("Cocodrilo verde bordado en el pecho");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Lacoste");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_785712-MLA71947754186_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_699487-MLA71947754194_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_838605-MLA71947754182_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_633931-MLA71947754192_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_793659-MLA71947754188_092023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Gris"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(5));
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Short H Relax Dayne De Jean Mujer 47 Street");
        producto.setDescripcion("Short de jean tipo bermuda, calce high relax (tiro relajado), lavado azul claro, con brocas fuertes en bolsillos y cintura. Botón y remaches personalizados, metal níquel.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("47 Street");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_839889-MLA72646235143_112023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_967881-MLA72646235145_112023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_816524-MLA72646235139_112023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Celeste"));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Zapatilla De Cuero Negra Rachi Mujer Heyas");
        producto.setDescripcion("Heyas es una empresa Argentina, dedicada al diseño, fabricación y comercialización de calzado femenino.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Heyas");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_857815-MLA71007055455_082023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_824024-MLA71007055457_082023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Negro"));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Sandalia Mujer Baja Comoda Anatomica Abrojo Moda Zante");
        producto.setDescripcion("Sandalia mujer Zante CUERO ECOLOGICO - No te quedes sin las tuyas!");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Becca Shoes");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_849274-MLA72224576131_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_681028-MLA72224585923_102023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Negro"));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Falda Corta Mujer Tolgu Sweet");
        producto.setMarca("Sweet");
        producto.setDescripcion("El modelo Minifalda Tolgu, es mini-skirt (corte pollera pantalón) con detalle de argolla de metal en su lateral izquierdo. Tiene cierre trasero");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_623299-MLA72221887395_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_927108-MLA72221887399_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_823095-MLA72221887405_102023-O.webp"));
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Marron"));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        producto.setFechaCreacion(LocalDate.now().minusMonths(1));
        productoService.save(producto);


        producto = new Producto();
        producto.setNombre("Shorts Hombre Deportivos Gimnasio Futbol Running Pantalon");
        producto.setMarca("La Feria Online");
        producto.setDescripcion("Los shorts deportivos de nuestra línea son el equilibrio perfecto entre comodidad y estilo. Confeccionados con materiales de alta calidad y cuidando cada detalle en su elaboración, estos shorts aseguran un calce excepcional que se adapta a tu cuerpo. Diseñados para brindar libertad de movimiento durante cualquier actividad física, su ajuste ergonómico te ofrece la comodidad que necesitas para entrenar con confianza. Descubre la combinación ideal de funcionalidad y moda con nuestros shorts deportivos, ¡tu aliado perfecto para lucir y sentirte genial mientras te mantienes activo!");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_642629-MLA44755392097_012021-O.webp","https://http2.mlstatic.com/D_NQ_NP_605261-MLA44464125133_122020-O.webp"));
        producto.setPrecio(4725);
        producto.setDescuento(10);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(5));
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Remera Manga Corta Billabong All Day Hombre");
        producto.setMarca("La Feria Online");
        producto.setDescripcion("Nuestra remera All Day Tee es un modelo institucional de la marca por ser la más elegida y que se renueva temporada tras temporada. Contiene una combinación de algodón con poliéster. Además es de la línea Essential con una variedad de talle de XS a XXXL. Seguimos confiando en este producto ya que es utilizable en cualquier momento, sino que también te genera un estilo único.");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_735297-MLA54428940668_032023-O.webp","https://http2.mlstatic.com/D_NQ_NP_735886-MLA54428733868_032023-O.webp","https://http2.mlstatic.com/D_NQ_NP_781401-MLA54428887268_032023-O.webp"));
        producto.setPrecio(17.999);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "XXL", "XXXL"));
        producto.setColor(Arrays.asList("Gris"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(5));
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        productoService.save(producto);


        producto = new Producto();
        producto.setNombre("Pantalon Guess");
        producto.setMarca("Guess");
        producto.setDescripcion("Todas nuestras prendas son seleccionadas con un proceso de curaduria detallista para que recibas un producto como nuevo de primeras marcas y excelente calidad. Tiro medio. Cintura 48 cm. Tela rigida.");
        producto.setImagen(Arrays.asList("https://galponderopaar.vtexassets.com/arquivos/ids/243270-1200-auto?v=638388542313800000&width=1200&height=auto&aspect=true", "https://galponderopaar.vtexassets.com/arquivos/ids/243271-1200-auto?v=638388542315530000&width=1200&height=auto&aspect=true"));
        producto.setPrecio(17.690);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "XXL", "XXXL"));
        producto.setColor(Arrays.asList("Gris"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(1));
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(15);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("CAMISA CASUAL DE LINO CELESTE");
        producto.setMarca("Betra");
        producto.setDescripcion("Camisa de lino en color celeste claro, con diseño liso en manga corta. Cuenta con cuello punta botón y calce regular fit. Confeccionado con 55% de Lino y 45% de Algodón. Ideal para combinar con un look casual. ");
        producto.setImagen(Arrays.asList("https://www.devre.la/media/catalog/product/d/e/devre-camisa_43d000082-050_101.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:"));
        producto.setPrecio(47999);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "XXL"));
        producto.setColor(Arrays.asList("Celeste"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("PANTALÓN CARGO BRADENTON");
        producto.setMarca("Bradenton");
        producto.setDescripcion("Pantalón cargo jogger línea 'Terra', de tela Ripstop con fibras de algodón. Con dos bolsillos delanteros y dos bolsillos con tapa y broche snap en laterales y un bolsillo tipo ojal con cierre espalda. Cintura elastizada con cordón de ajuste.");
        producto.setImagen(Arrays.asList("https://equus.vtexassets.com/arquivos/ids/259693-1600-auto?v=638284150674500000&width=1600&height=auto&aspect=true"," https://equus.vtexassets.com/arquivos/ids/259695-1600-auto?v=638284150690400000&width=1600&height=auto&aspect=true","https://equus.vtexassets.com/arquivos/ids/259698-1600-auto?v=638284150728600000&width=1600&height=auto&aspect=true"));
        producto.setPrecio(44999);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "XXL"));
        producto.setColor(Arrays.asList("Verde"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("CHOMBA VALENTINE");
        producto.setMarca("Valentine");
        producto.setDescripcion("Chomba de jersey micro rayado, línea 'Terra', con fibras de algodón, con estampado full print grande. Con cuello polo tejido a tono, y puños tejidos.");
        producto.setImagen(Arrays.asList("https://equus.vtexassets.com/arquivos/ids/259693-1600-auto?v=638284150674500000&width=1600&height=auto&aspect=true"," https://equus.vtexassets.com/arquivos/ids/259695-1600-auto?v=638284150690400000&width=1600&height=auto&aspect=true","https://equus.vtexassets.com/arquivos/ids/259698-1600-auto?v=638284150728600000&width=1600&height=auto&aspect=true"));
        producto.setPrecio(44999);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("XS", "S", "M", "L"));
        producto.setColor(Arrays.asList("Verde"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.MEN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Saco Lino Liso Fucsia");
        producto.setMarca("Valentine");
        producto.setDescripcion("Saco fucsia con doble solapa." +
                "Confeccionado en mezcla de lino y rayón, una tela fluida con textura levemente rústica, con cuerpo y súper cómoda." +
                "Cerramiento con botón, hombros marcados, forreria a tono. Calce recto, largo pasando la cadera.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24sacos034721136018_1_2.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24sacos034721136018_2_2.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24sacos034721136018_3_2.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24sacos034721136018_4_2.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(66900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("XS", "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Rosa"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(6));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(9);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Vestido Camisero Animal Print");
        producto.setMarca("Valentine");
        producto.setDescripcion("Vestido camisero full animal print crudo. Confeccionado en mezcla de lino y rayón, una tela fluida con textura levemente rústica, con cuerpo y súper cómoda! Dos bolsillos plaqué a la altura del pecho, manga corta rebatida, dos bolsillos insertados en las costuras laterales y acceso central por cartera de botones veteados. Calce holgado y ruedo redondeado, dorso levemente más largo. Composición: 55% Lino - 45% Rayón. Color: Amarillo");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti102922952013_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(44900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("XS", "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Amarillo"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(2));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Vestido Camisero Animal Print");
        producto.setMarca("Valentine");
        producto.setDescripcion("Vestido camisero full animal print crudo. Confeccionado en mezcla de lino y rayón, una tela fluida con textura levemente rústica, con cuerpo y súper cómoda! Dos bolsillos plaqué a la altura del pecho, manga corta rebatida, dos bolsillos insertados en las costuras laterales y acceso central por cartera de botones veteados. Calce holgado y ruedo redondeado, dorso levemente más largo. Composición: 55% Lino - 45% Rayón. Color: Amarillo");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti102922952013_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti102922952013_2_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti102922952013_4_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti102922952013_3_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(44900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("XS", "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Amarillo"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(2));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Vestido Halter con Recortes Azul Aero");
        producto.setMarca("Brave");
        producto.setDescripcion("Vestido largo colores combinados: azul, celeste, marrón y crudo. Confeccionado en algodón, una tela suave y liviana que asegura una sensación confortable y fresca durante todo el día. Cuello halter escote V en frente y espalda adaptable, cordón de la misma tela para fruncir y para anudar en el pecho. Posee un recorte central triangular que le otorga amplitud y corte evasé. El calce es holgado, con caída fluida y el ruedo amplio. Composición: 100% Algodón. Color: Azul Aero");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103022242043_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200", "https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103022242043_2_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103022242043_3_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200","https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103022242043_6_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(55900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList( "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Azul"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Short Sastrero Lino Verde");
        producto.setMarca("Brave");
        producto.setDescripcion("Short sastrero de verano en color verde. " +
                "Confeccionado en mezcla de lino y rayón, una tela fluida con textura levemente rústica, con cuerpo y súper cómoda. " +
                "Costuras a tono, cerramiento con doble gancho interior, cierre escondido bajo solapa, cintura con presillas, bolsillos laterales y pinza en cada pierna que le aporta amplitud y elegancia. Calce holgado, largo hasta mitad de muslos.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24short069321164022_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24short069321164022_2_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24short069321164022_2_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24short069321164022_5_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:"));
        producto.setPrecio(43900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList( "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Verde"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(12);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Camisa Lino Estampado Floral");
        producto.setMarca("Ellas");
        producto.setDescripcion("Camisa de lino estampada con diseño floral fantasía crudo sobre fondo naranja. Confeccionada en mezcla de lino y rayón, una tela fluida con textura levemente rústica, con cuerpo y súper cómoda. Cartera central de botones en color blanco, manga corta. Estructura amplia y cuadrada, calce relaxed.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24camis118422931017_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24camis118422931017_3_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24camis118422931017_5_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(31300);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList( "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Naranja Coral"));
        producto.setFechaCreacion(LocalDate.now().minusDays(5));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Vestido Estampado Breteles Finos");
        producto.setMarca("Ellas");
        producto.setDescripcion("Vestido estampa floral celeste y blanco con pintitas en color negro. Confeccionado en rayón, una tela súper liviana de gran fluidez y caida. Diseño sin mangas estilo musculosa, breteles finos, escote redondo en frente, espalda tipo mariposa, recorte central en el dorso. Calce evasé, perfecto para un look ¡súper fresco y colorido!");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103722942042_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103722942042_2_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103722942042_4_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24vesti103722942042_5_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(43900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList( "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Celeste"));
        producto.setFechaCreacion(LocalDate.now().minusDays(1));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(5);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Remera Lino Estampada");
        producto.setMarca("Ellas");
        producto.setDescripcion("Remera escote bote de lino estampada. Confeccionado en mezcla de lino y rayón, una tela fluida con textura levemente rústica, con cuerpo y super cómoda. Hombros caidos y manga 3/4, estampado de fantasia floral celeste y blanco. Estructura amplia y cuadrada, es de calce holgado.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v23remer421222942038_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v23remer421222942038_2_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v23remer421222942038_3_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v23remer421222942038_5_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(24900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList( "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Celeste"));
        producto.setFechaCreacion(LocalDate.now().minusDays(270));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Pantalón de Lino Celeste Estampado");
        producto.setMarca("Ellas");
        producto.setDescripcion("Pantalón tipo pijamero, estampado de flores celeste y blanco. Confeccionado en mezcla de lino, una tela hermosa para el verano super versatil para armarte cientos de looks. Cintura con elástico y cordón para anudar. Tiro alto, pierna angosta y calce suelto con caída. Bolsillos a frente.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v23panta160522942038_1_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v23panta160522942038_2_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v23panta160522942038_4_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v23panta160522942038_6_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(39900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList( "S", "M", "L","XL"));
        producto.setColor(Arrays.asList("Celeste"));
        producto.setFechaCreacion(LocalDate.now().minusDays(270));
        producto.setCategoria(Categoria.WOMAN);
        producto.setDescuento(0);
        productoService.save(producto);


        producto = new Producto();
        producto.setNombre("Collar Triple con Dije Corazón, Piedra y Sol.");
        producto.setMarca("Stones");
        producto.setDescripcion("Collar triple con dije colgante: Corazón, Piedra acrílica en color verde agua y Sol bañado en color oro. Enganche con mosquetón y cadena regulable.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24colla049341087601_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(7500);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Dorado"));
        producto.setFechaCreacion(LocalDate.now().minusDays(270));
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(21);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Collar Mostacillas y Cadenas");
        producto.setMarca("Stones");
        producto.setDescripcion("Collar materiales combinados en capas: 1- Cadena con baño dorado. 1- Cadena con mostacillas multicolor. 1- Cadena con letras que forman la palabra 'HAPPY' y mostacillas multicolor. 1- Cadena con dije colgante ☮. Enganche con mosquetón y cadena regulable. ");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24colla049941087601_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(6900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Dorado"));
        producto.setFechaCreacion(LocalDate.now().minusDays(5));
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(14);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Collar Piedritas Multicolor");
        producto.setMarca("Stones");
        producto.setDescripcion("Collar largo intermedio con pieza acrílica floral y piedritas multicolor. Cerramiento con mosquetón y cadenita para regular.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24colla049641000000_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24colla049641000000_2.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(7500);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Multicolor"));
        producto.setFechaCreacion(LocalDate.now().minusDays(2));
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(21);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Set de Bijouterie Baño Color Plateado");
        producto.setMarca("Stones");
        producto.setDescripcion("Pack de aro colgante y pulsera baño en color plata. Pulsera metálica con eslabones en forma de cadena irregular, cierre con mosquetón. Aro con eslabón metalico colgante, cerramiento con gancho mariposa. ");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/i/1i23packx901441087701_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:",
                "https://www.ver.com.ar/media/catalog/product/1/i/1i23packx901441087701_2.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:"));
        producto.setPrecio(4990);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Plata"));
        producto.setFechaCreacion(LocalDate.now().minusDays(2));
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Pulsera Eslabones Combinados");
        producto.setMarca("Stones");
        producto.setDescripcion("Pulsera con eslabones de dos tamaños enlazados y terminación con esfera. Enganche con mosquetón grande, regulable a gusto.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24pulse015541087701_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(5800);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Plata"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(16);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Collar Triple Eslabones Combinados");
        producto.setMarca("Stones");
        producto.setDescripcion("Collar triple cadena con eslabones combinados: 1- Cadena de eslabones clásicos. 1- Cadena combinada con mostacillas en baño dorado y dije geometrico. 1- Cadena de eslabones mini y dije colgante corazón con pieza acrílica en color rojo. Enganche con mosquetón y cadenita regulable.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24colla050541087601_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(6900);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Dorado"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(14);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Pulsera Dorada con Dijes");
        producto.setMarca("Stones");
        producto.setDescripcion("Pulsera de eslabones rectangulares texturados en metal con baño color oro y dijes: Corazón, Shell, Estrella de mar y Palmerita. Cerramiento con mosquetón y cadenita para regular.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24pulse015641087601_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(5600);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Dorado"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(13);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Pulsera Esclava con Nudo");
        producto.setMarca("Stones");
        producto.setDescripcion("Pulsera esclava fina con nudo marinero en el centro. Delicada, sutil y liviana. Ideal para acompañar tus looks!");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24pulse015441087701_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:",
                "https://www.ver.com.ar/media/catalog/product/1/v/1v24pulse015441087701_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:"));
        producto.setPrecio(5800);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Dorado"));
        producto.setFechaCreacion(LocalDate.now());
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(13);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Aros Medialuna Dorados");
        producto.setMarca("Stones");
        producto.setDescripcion("Aro semicircular con triple argolla en forma de medialuna con baño en color dorado. Cerramiento con gancho mariposa.");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24arosx019241087601_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(4800);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Dorado"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(4));
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(0);
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Aros Nudo Marinero Plateados");
        producto.setMarca("Stones");
        producto.setDescripcion("Aro argolla con detalle de nudo marinero en el centro. Cerramiento con gancho a presión. ");
        producto.setImagen(Arrays.asList("https://www.ver.com.ar/media/catalog/product/1/v/1v24arosx019141087701_1.jpg?optimize=high&bg-color=255,255,255&fit=bounds&height=1200&width=800&canvas=800:1200"));
        producto.setPrecio(4800);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setColor(Arrays.asList("Dorado"));
        producto.setFechaCreacion(LocalDate.now().minusMonths(5));
        producto.setCategoria(Categoria.JEWERLY);
        producto.setDescuento(0);
        productoService.save(producto);
    }
}
