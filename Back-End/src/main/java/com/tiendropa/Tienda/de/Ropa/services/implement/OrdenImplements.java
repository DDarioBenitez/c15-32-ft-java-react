package com.tiendropa.Tienda.de.Ropa.services.implement;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.CrudService;
import com.tiendropa.Tienda.de.Ropa.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.Orden;
import com.tiendropa.Tienda.de.Ropa.repositories.OrdenRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
public class OrdenImplements implements OrdenService
{
    @Autowired
    private OrdenRepository ordenRepository;


    @Override
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    @Override
    public boolean existsByIdAndUsuario(Long id, Usuario usuario) {
        return ordenRepository.existsByIdAndUsuario(id, usuario);
    }

    @Override
    public Orden findById(Long id) {
        return ordenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("La orden #%d no pudo ser encontrada", id)));
    }

    @Override
    public Orden findByIdAndUsuario(Long id, Usuario usuario) {
        return ordenRepository.findByIdAndUsuario(id, usuario);
    }

    @Override
    public void save(Orden entity) {
        ordenRepository.save(entity);
    }

}
