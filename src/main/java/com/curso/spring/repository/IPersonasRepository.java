package com.curso.spring.repository;

import com.curso.spring.model.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonasRepository
        extends CrudRepository<Persona, Long> {

}
