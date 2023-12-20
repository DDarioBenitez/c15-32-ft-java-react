package com.tiendropa.Tienda.de.Ropa.services.implement;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.ComentarioService;
import com.tiendropa.Tienda.de.Ropa.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.Comentario;
import com.tiendropa.Tienda.de.Ropa.repositories.ComentarioRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
public class ComentarioImplement implements ComentarioService
{
    @Autowired
    private ComentarioRepository comentarioRepository;


    @Override
    public void save(Comentario entity) {
         comentarioRepository.save(entity);
    }

    @Override
    public Comentario findById(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(long id) {
        return comentarioRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public boolean existsByIdAndUsuario(long id, Usuario usuario) {
        return comentarioRepository.existsByIdAndUsuario(id, usuario);
    }

    @Override
    public Comentario findByIdAndUsuario(long id, Usuario usuario) {
        return comentarioRepository.findByIdAndUsuario(id, usuario);
    }
}
