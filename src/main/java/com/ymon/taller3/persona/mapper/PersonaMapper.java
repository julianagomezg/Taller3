package com.ymon.taller3.persona.mapper;

import com.ymon.taller3.persona.dto.PersonaDTO;
import com.ymon.taller3.persona.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDTO personaToPersonaDTO(Persona persona);

    @Mapping(target = "id", ignore = true)
    Persona personaDTOToPersona(PersonaDTO personaDTO);

    PersonaDTO personaDTOWithoutId(Persona persona);
}
