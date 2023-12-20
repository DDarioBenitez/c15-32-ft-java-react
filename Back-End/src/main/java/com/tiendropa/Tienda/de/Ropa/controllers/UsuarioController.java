package com.tiendropa.Tienda.de.Ropa.controllers;

import com.tiendropa.Tienda.de.Ropa.dtos.UsuarioDTO;
import com.tiendropa.Tienda.de.Ropa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    @Secured("ADMIN")
    public ResponseEntity<Object> getAllUsers() {
        List users = usuarioService.findAll().stream().map(UsuarioDTO::new).toList();

        if(users.isEmpty()) {
            return new ResponseEntity<>("No se encontraron usuarios", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Object> getUser(@PathVariable long id) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.findById(id) == null) {
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new UsuarioDTO(usuarioService.findById(id)), HttpStatus.OK);
    }


    @GetMapping("/isActive")
    public ResponseEntity<Object> getActiveUsers(Authentication authentication) {
        if (authentication.isAuthenticated()){
            return new ResponseEntity<>(new UsuarioDTO(usuarioService.findByEmail(authentication.getName())), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("El usuario no existe o no esta logeado", HttpStatus.NOT_FOUND);
        }
    }
}
