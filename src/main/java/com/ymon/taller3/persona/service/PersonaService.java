package com.ymon.taller3.persona.service;

import com.ymon.taller3.persona.dto.PersonaDTO;
import com.ymon.taller3.persona.mapper.PersonaMapper;
import com.ymon.taller3.persona.model.Persona;
import com.ymon.taller3.persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    //Crear una persona.
    public Persona createPersonFromDTO(PersonaDTO personaDTO) {
        Persona persona = personaMapper.personaDTOToPersona(personaDTO);
        return personaRepository.save(persona);
    }

    //Obtener todas las personas.
    public List<Persona> getAllPeople() {
        return personaRepository.findAll();
    }

    //Obtener persona por Id.
    public Optional<Persona> getPersonById(Long id) {
        return personaRepository.findById(id);
    }

    //Actualizar una persona.
    public Persona updatePersonFromTDO(Long id, PersonaDTO personaDetails) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        persona.setSexo(personaDetails.getSexo());
        return personaRepository.save(persona);
    }

    //Eliminar una persona.
    public void deletePerson(Long id) {
        personaRepository.deleteById(id);
    }
}
