package com.ymon.taller3.libro.model;

import com.ymon.taller3.prestamo.model.Prestamo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "libro")
@Getter
@Setter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String isbn;
    private String titulo;

    @OneToOne(mappedBy = "idLibro", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Prestamo prestamo;

}
