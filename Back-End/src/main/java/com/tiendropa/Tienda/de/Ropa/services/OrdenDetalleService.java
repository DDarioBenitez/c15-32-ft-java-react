package com.tiendropa.Tienda.de.Ropa.services;

import com.tiendropa.Tienda.de.Ropa.models.OrdenDetalle;

import java.util.List;

public interface OrdenDetalleService {

    void save(OrdenDetalle entity);

    List<OrdenDetalle> findAll();

    OrdenDetalle findById(Long id);
}
