package com.tiendropa.Tienda.de.Ropa.configurations;

import com.tiendropa.Tienda.de.Ropa.enums.Rol;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    public UsuarioService usuarioService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputName -> {
            Usuario usuario = usuarioService.findByEmail(inputName);
            if (usuario != null){
                if(usuario.getRol() != Rol.ADMIN){
                    return new User(usuario.getEmail(), usuario.getPassword(), AuthorityUtils.createAuthorityList("CLIENTE"));
                }
                else{
                    return new User(usuario.getEmail(), usuario.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
                }
            }
            else {
                throw new UsernameNotFoundException("Unknown user " + inputName);
            }
        });
    }
}
