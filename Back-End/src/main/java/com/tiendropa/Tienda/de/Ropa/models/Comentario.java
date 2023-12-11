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
@Getter @Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String body;

    @CreationTimestamp
    private LocalDateTime fecha;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Usuario usuario;
}
