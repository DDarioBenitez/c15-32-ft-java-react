package com.tiendropa.Tienda.de.Ropa.repositories;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tiendropa.Tienda.de.Ropa.models.Orden;


public interface OrdenRepository extends JpaRepository<Orden, Long> {

    Orden findByIdAndUsuario(long id, Usuario usuario);

    boolean existsByIdAndUsuario(long id, Usuario usuario);
}
