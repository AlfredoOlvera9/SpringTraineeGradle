package com.curso.spring.service;

import com.curso.spring.dto.DireccionDTO;
import com.curso.spring.model.Direcciones;
import org.springframework.http.ResponseEntity;

public interface IDireccionService {
    ResponseEntity<?> crearDireccion(DireccionDTO direccionDTO);

}
