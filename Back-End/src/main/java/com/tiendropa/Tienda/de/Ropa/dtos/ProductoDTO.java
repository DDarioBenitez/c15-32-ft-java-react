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
    private BigDecimal precio;
    private String marca;
    private Categoria categoria;
    private String talle;
    private String color;

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.marca = producto.getMarca();
        this.categoria = producto.getCategoria();
        this.talle = producto.getTalle();
        this.color = producto.getColor();
    }
}
