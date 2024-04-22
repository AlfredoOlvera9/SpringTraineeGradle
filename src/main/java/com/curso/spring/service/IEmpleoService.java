package com.curso.spring.service;

import com.curso.spring.dto.EmpleoDTO;
import com.curso.spring.model.Empleos;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface IEmpleoService {

    ResponseEntity<?> crearEmpleo(EmpleoDTO empleoDTO);

}
