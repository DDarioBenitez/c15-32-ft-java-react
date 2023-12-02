package com.tiendropa.Tienda.de.Ropa.services;


public interface CrudService<T>
{
    Iterable<T> findAll();
    T findById(Long id);
    
    void save(T entity);
    void deleteById(Long id);
}
