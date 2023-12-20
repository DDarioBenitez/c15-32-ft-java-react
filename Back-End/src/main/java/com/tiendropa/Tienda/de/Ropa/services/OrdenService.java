package com.tiendropa.Tienda.de.Ropa.services;

import com.tiendropa.Tienda.de.Ropa.models.Orden;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;

import java.util.List;

public interface OrdenService {

    void save(Orden entity);

    Orden findById(Long id);

    Orden findByIdAndUsuario(Long id, Usuario usuario);

    List<Orden> findAll();

    boolean existsByIdAndUsuario(Long id, Usuario usuario);
}
