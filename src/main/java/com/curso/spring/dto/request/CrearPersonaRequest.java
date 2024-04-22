package com.curso.spring.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CrearPersonaRequest {
    private String tituloEmpleo;
    private String empresaEmpleo;
    private BigDecimal salarioEmpleo;
    private String calleDireccion;
    private String ciudadDireccion;
    private String estadoDireccion;
    private String codigoPostalDireccion;
    private String nombrePersona;
    private Integer edadPersona;
    private String generoPersona;


}
