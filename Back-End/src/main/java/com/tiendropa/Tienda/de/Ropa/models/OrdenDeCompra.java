package com.tiendropa.Tienda.de.Ropa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class OrdenDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private long id;

    @Getter@Setter
    private double precioTotal;

    @Getter@Setter
    private String metodoDePago;

    @Getter@Setter
    @ManyToOne
    private User user;

    @Getter
    @OneToMany(mappedBy = "ordenDeCompra", fetch = FetchType.EAGER)
    private List<Detalles> detalles= new ArrayList<>();

    public OrdenDeCompra (double precioTotal, String metodoDePago){
        this.precioTotal=precioTotal;
        this.metodoDePago=metodoDePago;
    }
    public long getId(){
        return this.id;
    }

    public void addDetalles(Detalles detalles){
        detalles.setOrdenDeCompra(this);
        this.detalles.add(detalles);
    }
}
