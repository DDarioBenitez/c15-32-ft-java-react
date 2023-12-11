package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.models.Orden;

import java.math.BigDecimal;
import java.util.List;

public class OrdenDTO {
    private long id;
    private BigDecimal precioTotal;
    private String metodoDePago;
    private List<OrdenDetalleDTO> detalles;

    public OrdenDTO(Orden orden){
        this.id = orden.getId();
        this.precioTotal = orden.getPrecioTotal();
        this.metodoDePago = orden.getMetodoDePago();
        this.detalles = orden.getDetalles().stream().map(OrdenDetalleDTO::new).toList();
    }
}