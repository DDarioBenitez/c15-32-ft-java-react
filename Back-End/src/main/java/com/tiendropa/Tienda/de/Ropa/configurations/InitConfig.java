package com.tiendropa.Tienda.de.Ropa.configurations;

import java.util.Arrays;
import java.util.Random;

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
    private PasswordEncoder encoder;


    @PostConstruct
    public void init()
    {
        Producto producto = null;
        Random rand = new Random();

        Usuario cliente = new Usuario();
        cliente.setEmail("cliente@mail.com");
        cliente.setPassword(encoder.encode("123"));
        cliente.setRol(Rol.CLIENT);
        usuarioService.save(cliente);

        Usuario admin = new Usuario();
        admin.setEmail("admin@mail.com");
        admin.setPassword(encoder.encode("123"));
        admin.setRol(Rol.ADMIN);
        usuarioService.save(admin);


        producto = new Producto();
        producto.setNombre("Musculosa Crepe Flowns - Off White Mujer Portsaid");
        producto.setDescripcion("Portsaid es la marca argentina orientada a superar las expectativas de una mujer en permanente evolución.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(12);
        producto.setMarca("Portsaid");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_608150-MLA72380528171_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_962922-MLA72380528173_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_900246-MLA72380528175_102023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Chomba Vatiare Beige");
        producto.setDescripcion("Chomba de piqué estampado full print, con cuello polo, de calce intermedio.. Composición : 100% Algodón");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Equus");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_600131-MLA51483246856_092022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_997054-MLA51483246859_092022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_822922-MLA51483246854_092022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Camisa Basica Recta Mujer Sweet Portel");
        producto.setDescripcion("Camisa larga corte clásico pero con detalles que la hacen especial. La unión entre su manga y puño tiene terminación de pequeñas pinzas dando efecto de frunce y pequeños pliegues. Tiene bolsillo funcional de lado derecho. Textil: Batista con algodón.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Sweet");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_862731-MLA72204366605_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_640885-MLA72204209867_102023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Vestido Doha Batik De Mujer 47 Street");
        producto.setDescripcion("BIENVENIDOS A LA TIENDA OFICIAL DE 47STREET");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("47 Street");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_637740-MLA52028206523_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_822093-MLA52028206530_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_860255-MLA52028206522_102022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Remera Customs O'neill");
        producto.setDescripcion("Tienda oficial O’Neill y Fallen Footwear");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Oneill Argentina");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_686904-MLA51935097446_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_937767-MLA51935097448_102022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_745780-MLA51935003931_102022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Vestido Sun Chasers Billabong Mujer");
        producto.setDescripcion("Este modelo esta creado para que puedas personalizar tu look y combinar estilo y comodidad en tu outfit. El vestido Sun Chasers es un modelo corto cruzado adelante y con mangas bombe, perfecto para que luzcas autentica y fresca. Confeccionado con fibrana estampada, con un diseño delicado y floreado. Enamorate de la originalidad y convertite en tu mejor versión.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Billabong");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_918181-MLA51304792604_082022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_862953-MLA51304858215_082022-O.webp", "https://http2.mlstatic.com/D_NQ_NP_986591-MLA51304848248_082022-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Remera De Hombre Th6709 Lacoste");
        producto.setDescripcion("Cocodrilo verde bordado en el pecho");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Lacoste");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_785712-MLA71947754186_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_699487-MLA71947754194_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_838605-MLA71947754182_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_633931-MLA71947754192_092023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_793659-MLA71947754188_092023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Short H Relax Dayne De Jean Mujer 47 Street");
        producto.setDescripcion("Short de jean tipo bermuda, calce high relax (tiro relajado), lavado azul claro, con brocas fuertes en bolsillos y cintura. Botón y remaches personalizados, metal níquel.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("47 Street");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_839889-MLA72646235143_112023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_967881-MLA72646235145_112023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_816524-MLA72646235139_112023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Zapatilla De Cuero Negra Rachi Mujer Heyas");
        producto.setDescripcion("Heyas es una empresa Argentina, dedicada al diseño, fabricación y comercialización de calzado femenino.");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Heyas");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_857815-MLA71007055455_082023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_824024-MLA71007055457_082023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Sandalia Mujer Baja Comoda Anatomica Abrojo Moda Zante");
        producto.setDescripcion("Sandalia mujer Zante CUERO ECOLOGICO - No te quedes sin las tuyas!");
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setMarca("Becca Shoes");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_849274-MLA72224576131_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_681028-MLA72224585923_102023-O.webp"));
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        producto = new Producto();
        producto.setNombre("Falda Corta Mujer Tolgu Sweet");
        producto.setMarca("Sweet");
        producto.setDescripcion("El modelo Minifalda Tolgu, es mini-skirt (corte pollera pantalón) con detalle de argolla de metal en su lateral izquierdo. Tiene cierre trasero");
        producto.setImagen(Arrays.asList("https://http2.mlstatic.com/D_NQ_NP_623299-MLA72221887395_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_927108-MLA72221887399_102023-O.webp", "https://http2.mlstatic.com/D_NQ_NP_823095-MLA72221887405_102023-O.webp"));
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);

        /* 
        producto = new Producto();
        producto.setNombre("NOMBRE");
        producto.setMarca("MARCA");
        producto.setDescripcion("DESCRIPCION");
        producto.setImagen(Arrays.asList("IMAGEN1"));
        producto.setPrecio(rand.nextInt(100) * 100);
        producto.setCantidad(rand.nextInt(90) + 1);
        producto.setTalle(Arrays.asList("L", "XL", "SM"));
        producto.setColor(Arrays.asList("Blanco"));
        productoService.save(producto);
        */
    }
}
