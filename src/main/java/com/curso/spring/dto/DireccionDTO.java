package com.curso.spring.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionDTO {
    private Long direccionId;

    private String calle;

    private String ciudad;

    private String estado;

    private String codigoPostal;

    public DireccionDTO (){

    }

    public DireccionDTO(Long direccionId, String calle, String ciudad, String estado, String codigoPostal) {
        this.direccionId = direccionId;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }
}
