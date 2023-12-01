package com.tiendropa.Tienda.de.Ropa.models;

import com.tiendropa.Tienda.de.Ropa.enums.Rol;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private long id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Rol rol;

    @Getter
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<OrdenDeCompra> ordenDeCompras=new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Comentario> comentarios= new ArrayList<>();

    public User (String email, String password, Rol rol){
        this.email=email;
        this.password=password;
        this.rol=rol;
    }

    public long getId(){
        return this.id;
    }

    public void addComentario(Comentario comentario){
        comentario.setUser(this);
        this.comentarios.add(comentario);
    }

    public void addOrdenDeCompra(OrdenDeCompra ordenDeCompra){
        ordenDeCompra.setUser(this);
        this.ordenDeCompras.add(ordenDeCompra);
    }
}
