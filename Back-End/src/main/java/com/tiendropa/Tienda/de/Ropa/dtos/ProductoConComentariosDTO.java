package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.enums.Categoria;
import com.tiendropa.Tienda.de.Ropa.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter
public class ProductoConComentariosDTO {
    private long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String marca;
    private Categoria categoria;
    private List<String> talle;
    private List<String> color;
    private double descuento;
    private List<String> imagen;
    private int cantidad;
    private boolean isActivo;
    private List<ComentarioDTO> comentarios;

    public ProductoConComentariosDTO(Producto producto){
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.marca = producto.getMarca();
        this.categoria = producto.getCategoria();
        this.talle = producto.getTalle();
        this.color = producto.getColor();
        this.descuento = producto.getDescuento();
        this.imagen = producto.getImagen();
        this.cantidad = producto.getCantidad();
        this.isActivo = producto.isActivo();
        this.comentarios=producto.getComentarios().stream().map(ComentarioDTO::new).toList();
    }
}
