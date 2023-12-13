package com.tiendropa.Tienda.de.Ropa.services.implement;

import com.tiendropa.Tienda.de.Ropa.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.Orden;
import com.tiendropa.Tienda.de.Ropa.repositories.OrdenRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class OrdenService implements CrudService<Orden>
{
    @Autowired
    private OrdenRepository ordenRepository;


    @Override
    public Iterable<Orden> findAll() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden findById(Long id) {
        return ordenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("La orden #%d no pudo ser encontrada", id)));
    }

    @Override
    public void save(Orden entity) {
        ordenRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        ordenRepository.deleteById(id);
    }
}
