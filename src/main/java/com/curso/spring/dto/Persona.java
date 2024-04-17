package com.curso.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Persona {

    @NotNull(message = "El campó nomnbre no pude ser vacio")
    private String nombre;

    @Pattern(regexp = "[0-9]{1,3}", message = "El campo solo admite n\u00fameros enteros y maximo 3 digitos")
    private String edad;

    private  String genero;

    @NotNull(message = "El campó  apellido no pude ser vacio")
    private String apellidoPaterno;

    private String apellidoMaterno;

    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String email;

    public Persona (){

    }

}
