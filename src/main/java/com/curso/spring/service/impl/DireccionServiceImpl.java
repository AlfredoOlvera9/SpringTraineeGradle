package com.curso.spring.service.impl;

import com.curso.spring.dto.DireccionDTO;
import com.curso.spring.model.Direcciones;
import com.curso.spring.repository.IDireccionRepository;
import com.curso.spring.service.IDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    IDireccionRepository repository;

    @Transactional
    @Override
    public ResponseEntity<?> crearDireccion(DireccionDTO direccionDTO) {
        try {
            Direcciones direcciones = new Direcciones();

            direcciones.setCalle(direccionDTO.getCalle());
            direcciones.setCiudad(direccionDTO.getCiudad());
            direcciones.setEstado(direccionDTO.getEstado());
            direcciones.setCodigoPostal(direccionDTO.getCodigoPostal());

            Direcciones direccionGuardada = repository.save(direcciones);

            DireccionDTO direccionGuardadaDto = new DireccionDTO();

            direccionGuardadaDto.setDireccionId(direccionGuardada.getDireccionId());
            direccionGuardadaDto.setCalle(direccionGuardada.getCalle());
            direccionGuardadaDto.setCiudad(direccionGuardada.getCiudad());
            direccionGuardadaDto.setCodigoPostal(direccionGuardada.getCodigoPostal());
            direccionGuardadaDto.setEstado(direccionGuardada.getEstado());

            return ResponseEntity.status(HttpStatus.CREATED).body(direccionGuardadaDto);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear direccion");

        }
    }



}
