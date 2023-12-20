package com.tiendropa.Tienda.de.Ropa.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Getter
public class NuevaOrdenDetalleDTO {

    private int cantidad;
    private double precioTotal;
    private long productoId;

}
