package com.curso.spring.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PersonaRequest {

    private Long personaId;

    //   @Column(name= "nombre")
    private String nombre;

    //  @Column(name= "edad")
    private Integer edad;

    //   @Column(name= "genero")
    private String genero;


    private Integer direccionId;


    private Integer empleoId;


}
