package com.ymon.taller3.prestamo.mapper;

import com.ymon.taller3.prestamo.dto.PrestamoDTO;
import com.ymon.taller3.prestamo.dto.PrestamoUpdateDTO;
import com.ymon.taller3.prestamo.model.Prestamo;
import com.ymon.taller3.usuario.dto.UsuarioRolDTO;
import com.ymon.taller3.usuario.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {

    PrestamoDTO prestamoToPrestamoDTO(Prestamo prestamo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idLibro.autor", ignore = true)
    @Mapping(target = "idLibro.isbn", ignore = true)
    @Mapping(target = "idLibro.titulo", ignore = true)
    @Mapping(target = "idUsuario.idPersona", ignore = true)
    @Mapping(target = "idUsuario.rol", ignore = true)
    Prestamo prestamoDTOToPrestamo(PrestamoDTO prestamoDTO);

    PrestamoDTO prestamoDTOWithoutId(Prestamo prestamo);

    PrestamoUpdateDTO prestamoToPrestamoUpdateDTO(Prestamo prestamo);
}