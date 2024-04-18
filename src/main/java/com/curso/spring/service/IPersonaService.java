package com.curso.spring.service;


import com.curso.spring.dto.PersonaDto;
import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.dto.response.DatosPersonaResponse;
import com.curso.spring.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

public interface IPersonaService {
    List<PersonaDto> findAll();

    Persona save (Persona persona);

    PersonaRequest save2 (PersonaRequest persona);

    // Usando Dto
    PersonaDto saveDto (Persona persona);

    Persona buscarPersonaId(Long id);

    ResponseEntity<Persona> updatePersona(PersonaDto request);

    void eliminarPersona(Long id);

    public List<String> getNombrePersonaByGenero(String genero);

    ResponseEntity<Object> getInfoPersona(@PathVariable Integer id);
}
