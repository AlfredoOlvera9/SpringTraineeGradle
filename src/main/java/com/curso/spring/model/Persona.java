package com.curso.spring.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name =" personas")
@Getter
@Setter
public class Persona {

    @Column(name = "persona_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personaId;

 //   @Column(name= "nombre")
    private String nombre;

  //  @Column(name= "edad")
    private Integer edad;

 //   @Column(name= "genero")
    private String genero;

    @Column(name= "direccion_id")
    private Integer direccionId;

    @Column(name= "empleo_id")
    private Integer empleoId;

}
