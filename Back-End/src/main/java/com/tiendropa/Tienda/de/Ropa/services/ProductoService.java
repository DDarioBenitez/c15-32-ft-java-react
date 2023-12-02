package com.tiendropa.Tienda.de.Ropa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.Producto;
import com.tiendropa.Tienda.de.Ropa.repositories.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ProductoService implements CrudService<Producto>
{
    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public Iterable<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("El producto #%d no pudo ser encontrado", id)));
    }

    @Override
    public void save(Producto entity) {
        productoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
