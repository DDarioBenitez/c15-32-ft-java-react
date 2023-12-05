package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private String rol;
    private List<OrdenDTO> orden = new ArrayList<>();
    private List<ComentarioDTO> comentarios = new ArrayList<>();

    UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.rol = user.getRol().name();
        this.orden = user.getOrden().stream().map(OrdenDTO::new).toList();
        this.comentarios = user.getComentarios().stream().map(ComentarioDTO::new).toList();
    }
     public UserDTO(long id, String email, String password, String rol){
        this.id=id;
        this.email=email;
        this.password=password;
        this.rol=rol;
     }
}
