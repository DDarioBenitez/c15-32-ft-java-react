package com.tiendropa.Tienda.de.Ropa.repositories;

import com.tiendropa.Tienda.de.Ropa.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tiendropa.Tienda.de.Ropa.models.Producto;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
    boolean existsById(long id);

}
