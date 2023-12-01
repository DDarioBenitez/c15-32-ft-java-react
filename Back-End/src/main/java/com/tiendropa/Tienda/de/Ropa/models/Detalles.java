package com.tiendropa.Tienda.de.Ropa.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@Entity
public class Detalles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private long id;

    @Setter@Getter
    private int cantidad;

    @Setter@Getter
    private double precioTotal;

    @Setter@Getter
    @ManyToOne
    private OrdenDeCompra ordenDeCompra;

    @Setter@Getter
    @ManyToOne
    private Producto producto;

    public Detalles (int cantidad, double precioTotal){
        this.cantidad=cantidad;
        this.precioTotal=precioTotal;
    }

    public long getId(){
        return this.id;
    }
}
