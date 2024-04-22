package com.curso.spring.repository;

import com.curso.spring.model.Direcciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDireccionRepository extends JpaRepository<Direcciones,Long> {

}
