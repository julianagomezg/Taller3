package com.ymon.taller3.libro.mapper;

import com.ymon.taller3.libro.dto.LibroDTO;
import com.ymon.taller3.libro.model.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibroMapper {
    LibroDTO libroTolibroDTO(Libro libro);

    @Mapping(target = "id", ignore = true)
    Libro libroDTOToLibro(LibroDTO libroDTO);

    LibroDTO LibroDTOWithoutId(Libro libro);
}