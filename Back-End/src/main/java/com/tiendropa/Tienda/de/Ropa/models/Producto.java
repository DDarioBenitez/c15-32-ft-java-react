package com.tiendropa.Tienda.de.Ropa.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tiendropa.Tienda.de.Ropa.enums.Categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "productos")
@NoArgsConstructor
@Getter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    private String nombre;
    @Setter
    private String descripcion;
    @Setter
    private double precio;
    @Setter
    private String marca;
    @Setter
    private Categoria categoria;
    @Setter
    @ElementCollection
    private List<String> talle= new ArrayList<>();
    @Setter
    @ElementCollection
    private List<String> color= new ArrayList<>();
    @Setter
    private double descuento;
    @Setter
    @ElementCollection
    private List<String> imagen= new ArrayList<>();
    @Setter
    private int cantidad;
    @Setter
    private boolean isActivo;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<OrdenDetalle> detalles = new ArrayList<>();

    public Producto(String nombre, String descripcion, double precio, String marca, Categoria categoria, List<String> talle, List<String> color, double descuento, List<String> imagen, int cantidad) {
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

    public void addComentario(Comentario comentario) {
        comentario.setProducto(this);
        this.comentarios.add(comentario);
    }
    public void addDetalle(OrdenDetalle detalle) {
        detalle.setProducto(this);
        this.detalles.add(detalle);
    }
}
