package com.curso.spring.controller;

import com.curso.spring.dto.Persona;
import com.curso.spring.service.IEjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-spring")
@Slf4j

public class HolaMundoController {

    @Autowired
    private IEjerciciosService ejerciciosService;



    @GetMapping("/hola")
    public String holaMundo (){

        return ("Hola mundo");

    }

    @GetMapping(path ="/hola/{nombre}")
    public String holaMundo2(@PathVariable String nombre) {
        log.info("El nombre que se envia es: "+ nombre);
        return "Hola: " + nombre;
    }

    @PostMapping("/persona")
    public Persona datosPersona(@RequestBody Persona persona){

        return persona;

    }

    @GetMapping("/nombres")
    public List<String> nombre (){
        return ejerciciosService.getNombres();
    }

}
