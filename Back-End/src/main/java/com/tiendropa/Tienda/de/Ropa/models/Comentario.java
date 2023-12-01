package com.tiendropa.Tienda.de.Ropa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private long id;

    @Setter@Getter
    private String body;

    @Setter@Getter
    private LocalDateTime fecha;

    @Setter@Getter
    @ManyToOne
    private Producto producto;

    @Setter@Getter
    @ManyToOne
    private User user;

    public Comentario(String body, LocalDateTime fecha){
        this.body=body;
        this.fecha=fecha;
    }

    public long getId(){
        return this.id;
    }
}
