package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.models.Comentario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor@AllArgsConstructor@Getter
public class ComentarioDTO {
    private long id;
    private String body;
    private LocalDateTime fecha;
    private ProductoDTO producto;
    private UserDTO user;

    public ComentarioDTO(Comentario comentario){
        this.id = comentario.getId();
        this.body = comentario.getBody();
        this.fecha = comentario.getFecha();
        this.producto = new ProductoDTO(comentario.getProducto());
    }
}
