package com.curso.spring.repository;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.dto.response.DatosPersonaResponse;
import com.curso.spring.model.Persona;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO personas (nombre, edad, genero, direccion_id, empleo_id) "
            + "VALUES (:#{#request.nombre}, :#{#request.edad}, :#{#request.genero}, "
            + ":#{#request.direccionId}, :#{#request.empleoId})", nativeQuery = true)
    Integer saveNativePerson(@Param("request") PersonaRequest request);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE personas SET nombre = :#{#request.nombre WHERE persona_id = :#{#request.idPersona}", nativeQuery = true)
    Integer updateNativePerson(@Param("request")PersonaRequest request);


    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM personas WHERE persona_id = :id", nativeQuery = true)
    void deleteByIdNative(@Param("id") Long id);





}
