package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.enums.Categoria;
import com.tiendropa.Tienda.de.Ropa.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter
public class ProductoDTO {
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
    private double puntuacion;

    public ProductoDTO(Producto producto) {
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
        this.puntuacion = producto.getPuntuacionActual();
    }
    public ProductoDTO(String nombre,String descripcion, double precio, String marca, Categoria categoria, List<String> talle, List<String> color, double descuento, List<String> imagen, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
        this.categoria = categoria;
        this.talle = talle;
        this.color = color;
        this.descuento = descuento;
        this.imagen = imagen;
        this.cantidad = cantidad;
    }
}
