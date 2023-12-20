package com.tiendropa.Tienda.de.Ropa.controllers;

import com.tiendropa.Tienda.de.Ropa.dtos.RegisterDTO;
import com.tiendropa.Tienda.de.Ropa.enums.Rol;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cliente")
    @Transactional
    public ResponseEntity<Object> registerUser(@RequestBody RegisterDTO nuevoUser) {
        if (usuarioService.existsByEmail(nuevoUser.getEmail())) {
            return new ResponseEntity<>("El email ya existe", HttpStatus.BAD_REQUEST);
        }
        if(nuevoUser.getEmail().isEmpty()){
            return new ResponseEntity<>("El email es incorrecto", HttpStatus.BAD_REQUEST);
        }
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!nuevoUser.getEmail().matches(regexEmail)) {
            return new ResponseEntity<>("El email no esta dentro de los parametros", HttpStatus.BAD_REQUEST);
        }
        if(nuevoUser.getPassword().isEmpty()){
            return new ResponseEntity<>("La contraseña es incorrecta", HttpStatus.BAD_REQUEST);
        }
        String regexPassword= "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        if (!nuevoUser.getPassword().matches(regexPassword)){
            return new ResponseEntity<>("La contraseña no esta dentro de los parametros", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(nuevoUser.getEmail(), passwordEncoder.encode(nuevoUser.getPassword()), Rol.CLIENT, nuevoUser.getNombre(), nuevoUser.getApellido(), nuevoUser.getTelefono());
        usuarioService.save(usuario);
        return new ResponseEntity<>("Usuario Creado Correctamente", HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<Object> registerAdmin(@RequestBody RegisterDTO nuevoUser) {
        if(nuevoUser.getEmail().isEmpty()){
            return new ResponseEntity<>("El email es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(nuevoUser.getPassword().isEmpty()){
            return new ResponseEntity<>("La contraseña es incorrecta", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(nuevoUser.getEmail(), passwordEncoder.encode(nuevoUser.getPassword()), Rol.ADMIN);
        usuarioService.save(usuario);
        return new ResponseEntity<>("Usuario Creado Correctamente", HttpStatus.CREATED);
    }
}
