package com.tiendropa.Tienda.de.Ropa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tiendropa.Tienda.de.Ropa.models.Orden;


public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
