package com.curso.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Persona {

    private String nombre;
    private int edad;
    private  String genero;
    private String apellidoPaterno;
    private String apellidoMaterno;

}
