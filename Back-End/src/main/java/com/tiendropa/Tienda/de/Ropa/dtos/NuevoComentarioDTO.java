package com.tiendropa.Tienda.de.Ropa.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor@AllArgsConstructor@Getter
public class NuevoComentarioDTO {
    private String body;

    private LocalDateTime fecha;

    private long idProducto;

    private long idUser;
}
