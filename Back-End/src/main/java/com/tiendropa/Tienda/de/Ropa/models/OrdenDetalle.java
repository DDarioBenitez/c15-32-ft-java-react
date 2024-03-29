package com.tiendropa.Tienda.de.Ropa.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ordenes_detalles")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class OrdenDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cantidad;

    private double precioTotal;

    @ManyToOne
    private Orden orden;

    @ManyToOne
    private Producto producto;

    public OrdenDetalle(int cantidad, double precioTotal) {
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;

    }
}
