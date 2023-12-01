package com.tiendropa.Tienda.de.Ropa.models;

import com.tiendropa.Tienda.de.Ropa.enums.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private long id;

    @Setter@Getter
    private String nombre;

    @Setter@Getter
    private String descripcion;

    @Setter@Getter
    private double precio;

    @Setter@Getter
    private String marca;

    @Setter@Getter
    private Categoria categoria;

    @Setter@Getter
    private String talle;

    @Setter@Getter
    private String color;

    @Getter
    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<Comentario> comentarios= new ArrayList<>();

    public Producto(String nombre, String descripcion, double precio, String marca, Categoria categoria, String talle, String color){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.marca=marca;
        this.categoria= categoria;
        this.talle= talle;
        this.color= color;
    }
    public long getId(){
        return this.id;
    }

    public void addCometario(Comentario comentario){
        comentario.setProducto(this);
        this.comentarios.add(comentario);
    }
}
