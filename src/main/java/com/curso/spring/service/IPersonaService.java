package com.curso.spring.service;


import com.curso.spring.dto.PersonaDto;
import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Persona;

import java.util.List;

public interface IPersonaService {
    List<PersonaDto> findAll();

    Persona save (Persona persona);

    PersonaRequest save2 (PersonaRequest persona);

    // Usando Dto
    PersonaDto saveDto (Persona persona);

}
