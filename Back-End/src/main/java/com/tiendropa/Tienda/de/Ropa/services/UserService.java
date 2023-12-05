package com.tiendropa.Tienda.de.Ropa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.models.User;
import com.tiendropa.Tienda.de.Ropa.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class UserService implements CrudService<User>
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("El producto #%d no pudo ser encontrado", id)));
    }

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
