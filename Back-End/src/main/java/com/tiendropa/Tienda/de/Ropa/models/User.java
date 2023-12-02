package com.tiendropa.Tienda.de.Ropa.models;

import java.util.ArrayList;
import java.util.List;

import com.tiendropa.Tienda.de.Ropa.enums.Rol;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private Rol rol;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Orden> orden = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Comentario> comentarios = new ArrayList<>();

    
    public void addComentario(Comentario comentario) {
        comentario.setUser(this);
        this.comentarios.add(comentario);
    }

    public void addOrden(Orden orden) {
        orden.setUser(this);
        this.orden.add(orden);
    }
}
