package com.tiendropa.Tienda.de.Ropa.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tiendropa.Tienda.de.Ropa.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "productos")
@NoArgsConstructor
@Getter @Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private String marca;

    private Categoria categoria;

    private String talle;

    private String color;

    private double descuento;

    private String imagen;

    private int cantidad;

    private boolean isActivo;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<OrdenDetalle> detalles = new ArrayList<>();

    public Producto(String nombre, String descripcion, double precio, String marca, Categoria categoria, String talle, String color, double descuento, String imagen, int cantidad) {
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
        this.isActivo = true;
    }

    public void addCometario(Comentario comentario) {
        comentario.setProducto(this);
        this.comentarios.add(comentario);
    }
    public void addDetalle(OrdenDetalle detalle) {
        detalle.setProducto(this);
        this.detalles.add(detalle);
    }
}
