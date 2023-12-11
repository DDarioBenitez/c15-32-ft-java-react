package com.tiendropa.Tienda.de.Ropa.services;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;

import java.util.List;

public interface UserService {
    void save(Usuario usuario);

    List<Usuario> findAll();

    Usuario findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);

    Usuario findByEmail(String email);
}
