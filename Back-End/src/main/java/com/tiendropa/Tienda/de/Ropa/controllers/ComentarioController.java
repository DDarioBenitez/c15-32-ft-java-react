package com.tiendropa.Tienda.de.Ropa.controllers;

import com.tiendropa.Tienda.de.Ropa.dtos.ComentarioDTO;
import com.tiendropa.Tienda.de.Ropa.dtos.NuevoComentarioDTO;
import com.tiendropa.Tienda.de.Ropa.models.Comentario;
import com.tiendropa.Tienda.de.Ropa.models.Producto;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.ComentarioService;
import com.tiendropa.Tienda.de.Ropa.services.ProductoService;
import com.tiendropa.Tienda.de.Ropa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    @Transactional
    public ResponseEntity<Object> addComentario(@RequestBody NuevoComentarioDTO nuevoComentarioDTO){
        if (nuevoComentarioDTO.getIdProducto() <= 0 || !productoService.existsById(nuevoComentarioDTO.getIdProducto())) {
            return new ResponseEntity<>("El id del producto es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if (nuevoComentarioDTO.getIdUser() <= 0 || !usuarioService.existsById(nuevoComentarioDTO.getIdUser())) {
            return new ResponseEntity<>("El id del usuario es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if (nuevoComentarioDTO.getBody().isEmpty()) {
            return new ResponseEntity<>("El comentario es incorrecto", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = usuarioService.findById(nuevoComentarioDTO.getIdUser());
        Producto producto = productoService.findById(nuevoComentarioDTO.getIdProducto());
        Comentario comentario = new Comentario(nuevoComentarioDTO.getBody(), LocalDateTime.now());
        producto.addComentario(comentario);
        usuario.addComentario(comentario);
        productoService.save(producto);
        usuarioService.save(usuario);
        comentarioService.save(comentario);
        return new ResponseEntity<>("Comentario añadido con exito", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllComentarios(){
        List <ComentarioDTO> comentarioDTOS = comentarioService.findAll().stream().map(ComentarioDTO::new).toList();
        return new ResponseEntity<>(comentarioDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getComentarioById(@PathVariable Long id){
        if (id <= 0 || !comentarioService.existsById(id)) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ComentarioDTO(comentarioService.findById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deleteComentarioById(@PathVariable Long id){
        if (id <= 0 || !comentarioService.existsById(id)) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        comentarioService.deleteById(id);
        return new ResponseEntity<>("Comentario eliminado con exito", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> updateComentarioById(@PathVariable Long id, @RequestBody NuevoComentarioDTO nuevoComentarioDTO){
        if (id <= 0 || !comentarioService.existsById(id)) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if (nuevoComentarioDTO.getBody().isEmpty()) {
            return new ResponseEntity<>("El comentario es incorrecto", HttpStatus.BAD_REQUEST);
        }
        Comentario comentario = comentarioService.findById(id);
        comentario.setBody(nuevoComentarioDTO.getBody());
        comentario.setFecha(LocalDateTime.now());
        comentarioService.save(comentario);
        return new ResponseEntity<>("Comentario actualizado con exito", HttpStatus.OK);
    }
}
