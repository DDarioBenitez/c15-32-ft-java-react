package com.tiendropa.Tienda.de.Ropa.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter
public class NuevaOrdenDTO {

    List<NuevaOrdenDetalleDTO> detalles;

}
