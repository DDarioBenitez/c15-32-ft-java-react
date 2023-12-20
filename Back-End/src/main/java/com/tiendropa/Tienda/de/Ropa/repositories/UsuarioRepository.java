package com.tiendropa.Tienda.de.Ropa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);
}
