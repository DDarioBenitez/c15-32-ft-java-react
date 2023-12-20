package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.models.OrdenDetalle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor@NoArgsConstructor@Getter
public class OrdenDetalleDTO {
    private long id;
    private int cantidad;
    private double precioTotal;
    private ProductoDTO producto;

    public OrdenDetalleDTO(OrdenDetalle ordenDetalle) {
        this.id = ordenDetalle.getId();
        this.cantidad = ordenDetalle.getCantidad();
        this.precioTotal = ordenDetalle.getPrecioTotal();
        this.producto = new ProductoDTO(ordenDetalle.getProducto());

    }
}
