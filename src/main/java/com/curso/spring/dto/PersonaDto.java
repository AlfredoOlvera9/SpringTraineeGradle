package com.curso.spring.dto;

import com.curso.spring.model.Direcciones;
import com.curso.spring.model.Empleos;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
// DTO enviar cierta informacion al cliente

public class PersonaDto {

    private Long personaId;

    private String nombre;

    private Direcciones direccionId;

    private Empleos empleoId;

    private PersonaDto () {

    }

    public PersonaDto(Long personaId, String nombre, Direcciones direccionId, Empleos empleoId) {
        this.personaId = personaId;
        this.nombre = nombre;
        this.direccionId = direccionId;
        this.empleoId = empleoId;
    }
}
