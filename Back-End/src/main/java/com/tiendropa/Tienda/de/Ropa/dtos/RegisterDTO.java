package com.tiendropa.Tienda.de.Ropa.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Getter
public class RegisterDTO {
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private String telefono;
}
