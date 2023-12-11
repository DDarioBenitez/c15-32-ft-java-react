package com.tiendropa.Tienda.de.Ropa.controllers;

import com.tiendropa.Tienda.de.Ropa.dtos.UserDTO;
import com.tiendropa.Tienda.de.Ropa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers() {
        List users = userService.findAll().stream().map(UserDTO::new).toList();

        if(users.isEmpty()) {
            return new ResponseEntity<>("No se encontraron usuarios", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable long id) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(userService.findById(id) == null) {
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new UserDTO(userService.findById(id)), HttpStatus.OK);
    }

}
