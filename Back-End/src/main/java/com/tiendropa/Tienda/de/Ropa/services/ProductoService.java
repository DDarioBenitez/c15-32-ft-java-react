package com.tiendropa.Tienda.de.Ropa.services;

import com.tiendropa.Tienda.de.Ropa.models.Producto;

import java.util.List;

public interface ProductoService {

    void save(Producto producto);

    List<Producto> findAll();

    Producto findById(Long id);

    void deleteById(Long id);

    boolean existsById(long id);
}
