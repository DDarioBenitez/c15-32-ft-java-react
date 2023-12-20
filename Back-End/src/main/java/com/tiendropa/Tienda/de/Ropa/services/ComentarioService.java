package com.tiendropa.Tienda.de.Ropa.services;

import com.tiendropa.Tienda.de.Ropa.models.Comentario;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;

import java.util.List;

public interface ComentarioService {
    void save(Comentario entity);
    Comentario findById(Long id);
    boolean existsById(long id);
    void deleteById(Long id);
    List<Comentario> findAll();
    boolean existsByIdAndUsuario(long id, Usuario usuario);

    Comentario findByIdAndUsuario(long id, Usuario usuario);
}
