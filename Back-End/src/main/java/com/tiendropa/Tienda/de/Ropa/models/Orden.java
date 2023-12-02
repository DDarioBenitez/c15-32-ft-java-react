package com.tiendropa.Tienda.de.Ropa.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ordenes")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal precioTotal;

    private String metodoDePago;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "orden", fetch = FetchType.EAGER)
    private List<OrdenDetalle> detalles = new ArrayList<>();
    

    public void addDetalles(OrdenDetalle detalles) 
    {
        detalles.setOrden(this);
        this.detalles.add(detalles);
    }
}
