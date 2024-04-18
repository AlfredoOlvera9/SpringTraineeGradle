package com.curso.spring.dto.mapper;

import com.curso.spring.dto.PersonaDto;
import com.curso.spring.model.Persona;


// la clase mapper mapea nuestra entidad a nuestro dto, usando una
// forma elegante usando el patron de diseño builder
public class MapperPersonaDto {


    private Persona persona;

    //Constructor privado para que no se pueda instanciar
    //la creacion se maneja con el metodo estatico builder
    private MapperPersonaDto (){

    }

    //1.- Crea y devuelve la instancia, unica por cada respuesta
    public static MapperPersonaDto builder() {
            return new MapperPersonaDto();

    }

    //2.- Seteamos a la persona y seguimos devolviendo la instancia
    public MapperPersonaDto setPersona(Persona persona) {

        this.persona = persona;
        return this;
    }

    //Ahora devuelve la persona dto con los datos de la entidad, con los atributos deseados
    public PersonaDto build(){

        if(persona == null ){
            throw new RuntimeException("Debe pasar el entity Persona ");
        }

        return new PersonaDto(this.persona.getPersonaId(), persona.getNombre(), persona.getDireccionId(), persona.getEmpleoId());

    }

}
