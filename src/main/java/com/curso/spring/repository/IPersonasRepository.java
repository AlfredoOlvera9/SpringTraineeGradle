package com.curso.spring.repository;

import com.curso.spring.dto.response.DatosPersonaResponse;
import com.curso.spring.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonasRepository
        extends CrudRepository<Persona, Long> {

    @Query(value ="SELECT p.nombre FROM Persona p WHERE p.genero = :genero ")
    List<String> personasByGenero(@Param("genero")String genero);

    @Query(value = "SELECT p.nombre , e.titulo , e.salario "
                 + "FROM personas p "
                 + "JOIN empleos e ON p.empleo_id = e.empleo_id "
                 + "WHERE p.persona_id = :idPersona", nativeQuery = true)
    DatosPersonaResponse getInfoPersona(@Param("idPersona") Integer idPersona);

}
