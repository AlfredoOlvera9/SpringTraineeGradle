package com.curso.spring.repository;

import com.curso.spring.model.Empleos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleoRepository extends JpaRepository<Empleos,Long> {

}
