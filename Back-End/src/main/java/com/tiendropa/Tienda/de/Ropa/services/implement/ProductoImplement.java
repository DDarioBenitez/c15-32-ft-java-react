package com.tiendropa.Tienda.de.Ropa.services.implement;

import com.tiendropa.Tienda.de.Ropa.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.Producto;
import com.tiendropa.Tienda.de.Ropa.repositories.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
public class ProductoImplement implements ProductoService
{
    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("El producto #%d no pudo ser encontrado", id)));
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
