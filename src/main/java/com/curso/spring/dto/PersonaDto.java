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

    private Integer edad;

    private String genero;

    private Direcciones direccionId;

    private Empleos empleoId;

    public PersonaDto () {

    }

    public PersonaDto(Long personaId, String nombre, Integer edad,String genero, Direcciones direccionId, Empleos empleoId) {
        this.personaId = personaId;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.direccionId = direccionId;
        this.empleoId = empleoId;
    }


}
