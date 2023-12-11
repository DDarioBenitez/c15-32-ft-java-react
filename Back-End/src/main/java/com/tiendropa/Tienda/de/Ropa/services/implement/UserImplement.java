package com.tiendropa.Tienda.de.Ropa.services.implement;

import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendropa.Tienda.de.Ropa.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
public class UserImplement implements UserService
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("El producto #%d no pudo ser encontrado", id)));
    }

    @Override
    public void save(Usuario entity) {
        userRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
