package com.curso.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PersonaCreacionDTO {

    private Long id;
    private String nombre;
    private Integer edad;
    private String genero;
    private DireccionDTO direccion;
    private EmpleoDTO empleo;


}
