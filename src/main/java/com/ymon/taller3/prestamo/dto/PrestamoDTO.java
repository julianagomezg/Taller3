package com.ymon.taller3.prestamo.dto;

import com.ymon.taller3.libro.dto.LibroIdDto;
import com.ymon.taller3.usuario.dto.UsuarioIdDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PrestamoDTO {

    private UsuarioIdDTO idUsuario;
    private LibroIdDto idLibro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean prestado;

}
