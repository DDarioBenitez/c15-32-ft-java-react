package com.tiendropa.Tienda.de.Ropa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.Comentario;
import com.tiendropa.Tienda.de.Ropa.repositories.ComentarioRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ComentarioService implements CrudService<Comentario>
{
    @Autowired
    private ComentarioRepository comentarioRepository;


    @Override
    public Iterable<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario findById(Long id) {
        return comentarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("El comentario #%d no pudo ser encontrado", id)));
    }

    @Override
    public void save(Comentario entity) {
        comentarioRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        comentarioRepository.deleteById(id);
    }
}
