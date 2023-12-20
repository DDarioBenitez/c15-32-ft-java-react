package com.tiendropa.Tienda.de.Ropa.controllers;

import com.tiendropa.Tienda.de.Ropa.dtos.ProductoConComentariosDTO;
import com.tiendropa.Tienda.de.Ropa.dtos.ProductoDTO;
import com.tiendropa.Tienda.de.Ropa.enums.Categoria;
import com.tiendropa.Tienda.de.Ropa.models.Producto;
import com.tiendropa.Tienda.de.Ropa.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllProductos() {
        List<ProductoDTO> productos = productoService.findAll().stream().map(ProductoDTO::new).toList();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProducto(@PathVariable long id) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ProductoConComentariosDTO(productoService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/add")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<Object> addProducto(@RequestBody ProductoDTO producto) {
        if (producto.getNombre().isEmpty()) {
            return new ResponseEntity<>("El nombre es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if (producto.getDescripcion().isEmpty()) {
            return new ResponseEntity<>("La descripcion es incorrecta", HttpStatus.BAD_REQUEST);
        }
        if (producto.getPrecio() <= 0) {
            return new ResponseEntity<>("El precio es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if (producto.getMarca().isEmpty()) {
            return new ResponseEntity<>("La marca es incorrecta", HttpStatus.BAD_REQUEST);
        }
        if (producto.getCategoria() == null) {
            return new ResponseEntity<>("La categoria es incorrecta", HttpStatus.BAD_REQUEST);
        }
        if (producto.getTalle().isEmpty()) {
            return new ResponseEntity<>("El talle es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if (producto.getColor().isEmpty()) {
            return new ResponseEntity<>("El color es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if (producto.getDescuento() < 0) {
            return new ResponseEntity<>("El descuento es incorrecto", HttpStatus.BAD_REQUEST);
        }

        Producto productoNuevo = new Producto(producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getMarca(), producto.getCategoria(), producto.getTalle(),
                producto.getColor(), producto.getDescuento(), producto.getImagen(), producto.getCantidad());
        productoService.save(productoNuevo);

        return new ResponseEntity<>("Producto Agregado con Exito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<Object> deleteProducto(@PathVariable long id) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(productoService.existsById(id)) {
            Producto producto = productoService.findById(id);
            producto.setActivo(false);
            return new ResponseEntity<>("Producto Eliminado con Exito", HttpStatus.OK);
        }
        return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update/stock/{id}")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<Object> updateStock(@PathVariable long id, @RequestParam int cantidad) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(cantidad < 0) {
            return new ResponseEntity<>("La cantidad es incorrecta", HttpStatus.BAD_REQUEST);
        }
        if(productoService.existsById(id)) {
            Producto producto = productoService.findById(id);
            producto.setCantidad(producto.getCantidad() + cantidad);
            return new ResponseEntity<>("Stock Actualizado con Exito", HttpStatus.OK);
        }
        return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update/descuento/{id}")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<Object> updateDescuento(@PathVariable long id, @RequestParam double descuento) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(descuento < 0) {
            return new ResponseEntity<>("El descuento es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(productoService.existsById(id)) {
            Producto producto = productoService.findById(id);
            producto.setDescuento(descuento);
            return new ResponseEntity<>("Descuento Actualizado con Exito", HttpStatus.OK);
        }
        return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update/imagen/{id}")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<Object> updateImage(@PathVariable long id, @RequestParam String imagen) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(imagen.isEmpty()) {
            return new ResponseEntity<>("La imagen es incorrecta", HttpStatus.BAD_REQUEST);
        }
        if(productoService.existsById(id)) {
            Producto producto = productoService.findById(id);
            producto.getImagen().add(imagen);
            return new ResponseEntity<>("Imagen Actualizada con Exito", HttpStatus.OK);
        }
        return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update/precio/{id}")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<Object> updatePrecio(@PathVariable long id, @RequestParam double precio) {
        if (id <= 0) {
            return new ResponseEntity<>("El id es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(precio <= 0) {
            return new ResponseEntity<>("El precio es incorrecto", HttpStatus.BAD_REQUEST);
        }
        if(productoService.existsById(id)) {
            Producto producto = productoService.findById(id);
            producto.setPrecio(precio);
            return new ResponseEntity<>("Precio Actualizado con Exito", HttpStatus.OK);
        }
        return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
    }

}
