package com.tiendropa.Tienda.de.Ropa.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Getter
public class DeleteComentarioDTO {
    private long id;
    private long idUsuario;
    private long idProducto;
}
