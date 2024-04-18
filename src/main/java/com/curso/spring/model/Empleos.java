package com.curso.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "empleos")
@Getter
@Setter

public class Empleos {

    @Column(name = "empleo_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleoId;

    private String titulo;

    private String empresa;

    private BigDecimal salario;

}
