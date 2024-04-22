package com.curso.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class EmpleoDTO {

    private Long empleoId;

    private String titulo;

    private String empresa;

    private BigDecimal salario;

    public EmpleoDTO(){

    }
    public EmpleoDTO(Long empleoId, String titulo, String empresa, BigDecimal salario) {
        this.empleoId = empleoId;
        this.titulo = titulo;
        this.empresa = empresa;
        this.salario = salario;
    }
}
