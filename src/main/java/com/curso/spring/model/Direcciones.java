package com.curso.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "direcciones")
@Getter
@Setter
public class Direcciones {

    @Column(name = "direccion_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long direccionId;

    private String calle;

    private String ciudad;

    private String estado;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    public Direcciones(){

    }
    public Direcciones(Long direccionId) {
    }
}

