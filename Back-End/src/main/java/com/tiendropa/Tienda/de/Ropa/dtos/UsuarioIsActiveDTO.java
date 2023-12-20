package com.tiendropa.Tienda.de.Ropa.dtos;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Getter
public class UsuarioIsActiveDTO {
    private long id;
    private String email;
    private String nombre;
    private String apellido;
    private String telefono;
    private String rol;

    public UsuarioIsActiveDTO(Usuario usuario){
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.telefono = usuario.getTelefono();
        this.rol = usuario.getRol().name();
    }
}
