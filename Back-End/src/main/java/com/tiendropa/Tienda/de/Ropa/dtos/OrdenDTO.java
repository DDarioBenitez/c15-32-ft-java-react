package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.models.Orden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor@NoArgsConstructor@Getter
public class OrdenDTO {
    private long id;
    private double precioTotal;
    private List<OrdenDetalleDTO> detalles;

    public OrdenDTO(Orden orden){
        this.id = orden.getId();
        this.precioTotal = orden.getPrecioTotal();
        this.detalles = orden.getDetalles().stream().map(OrdenDetalleDTO::new).toList();
    }
}
