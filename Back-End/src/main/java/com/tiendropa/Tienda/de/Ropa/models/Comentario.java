package com.tiendropa.Tienda.de.Ropa.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "comentarios")
@NoArgsConstructor @AllArgsConstructor
@Getter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    private String body;
    @Setter
    private LocalDateTime fecha;
    @Setter
    @ManyToOne
    private Producto producto;
    @Setter
    @ManyToOne
    private Usuario usuario;


    public Comentario(String body, LocalDateTime fecha) {
        this.body = body;
        this.fecha = fecha;
    }
}
