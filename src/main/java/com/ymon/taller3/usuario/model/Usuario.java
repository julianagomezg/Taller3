package com.ymon.taller3.usuario.model;

import com.ymon.taller3.persona.model.Persona;
import com.ymon.taller3.prestamo.model.Prestamo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_persona")
    private Persona idPersona;

    private String rol;

    @OneToOne(mappedBy = "idUsuario", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Prestamo prestamo;

}