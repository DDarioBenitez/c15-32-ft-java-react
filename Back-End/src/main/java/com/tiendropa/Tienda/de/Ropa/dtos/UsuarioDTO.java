package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter
public class UsuarioDTO {
    private long id;
    private String email;
    private String password;
    private String rol;
    private List<OrdenDTO> orden = new ArrayList<>();
    private List<ComentarioDTO> comentarios = new ArrayList<>();

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.rol = usuario.getRol().name();
        this.orden = usuario.getOrden().stream().map(OrdenDTO::new).toList();
        this.comentarios = usuario.getComentarios().stream().map(ComentarioDTO::new).toList();
    }
     public UsuarioDTO(long id, String email, String password, String rol){
        this.id=id;
        this.email=email;
        this.password=password;
        this.rol=rol;
     }

}
