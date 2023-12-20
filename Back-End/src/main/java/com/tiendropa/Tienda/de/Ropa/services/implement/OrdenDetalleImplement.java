package com.tiendropa.Tienda.de.Ropa.services.implement;

import com.tiendropa.Tienda.de.Ropa.services.CrudService;
import com.tiendropa.Tienda.de.Ropa.services.OrdenDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.OrdenDetalle;
import com.tiendropa.Tienda.de.Ropa.repositories.OrdenDetalleRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
public class OrdenDetalleImplement implements OrdenDetalleService
{
    @Autowired
    private OrdenDetalleRepository ordenDetalleRepository;


    @Override
    public List<OrdenDetalle> findAll() {
        return ordenDetalleRepository.findAll();
    }

    @Override
    public OrdenDetalle findById(Long id) {
        return ordenDetalleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("El ordenDetalle #%d no pudo ser encontrado", id)));
    }

    @Override
    public void save(OrdenDetalle entity) {
        ordenDetalleRepository.save(entity);
    }

}
