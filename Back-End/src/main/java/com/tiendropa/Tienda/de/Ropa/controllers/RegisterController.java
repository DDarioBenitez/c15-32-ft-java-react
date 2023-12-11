package com.tiendropa.Tienda.de.Ropa.controllers;

import com.tiendropa.Tienda.de.Ropa.dtos.RegisterDTO;
import com.tiendropa.Tienda.de.Ropa.enums.Rol;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cliente")
    public ResponseEntity<Object> registerUser(@RequestBody RegisterDTO nuevoUser) {
        System.out.println(nuevoUser.getPassword());
        if(nuevoUser.getEmail().isEmpty()){
            return new ResponseEntity<>("El email es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(nuevoUser.getPassword().isEmpty()){
            return new ResponseEntity<>("La contraseña es incorrecta", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(nuevoUser.getEmail(), passwordEncoder.encode(nuevoUser.getPassword()), Rol.CLIENT);
        userService.save(usuario);
        return new ResponseEntity<>("Usuario Creado Correctamente", HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<Object> registerAdmin(@RequestBody RegisterDTO nuevoUser) {
        if(nuevoUser.getEmail().isEmpty()){
            return new ResponseEntity<>("El email es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(nuevoUser.getPassword().isEmpty()){
            return new ResponseEntity<>("La contraseña es incorrecta", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(nuevoUser.getEmail(), passwordEncoder.encode(nuevoUser.getPassword()), Rol.ADMIN);
        userService.save(usuario);
        return new ResponseEntity<>("Usuario Creado Correctamente", HttpStatus.CREATED);
    }
}