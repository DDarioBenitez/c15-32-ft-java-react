package com.tiendropa.Tienda.de.Ropa.repositories;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tiendropa.Tienda.de.Ropa.models.Comentario;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    boolean existsById(long id);
    boolean existsByIdAndUsuario(long id, Usuario usuario);

    Comentario findById(long id);
    Comentario findByIdAndUsuario(long id, Usuario usuario);
}
