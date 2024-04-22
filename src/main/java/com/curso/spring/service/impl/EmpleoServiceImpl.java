package com.curso.spring.service.impl;

import com.curso.spring.dto.EmpleoDTO;
import com.curso.spring.model.Empleos;
import com.curso.spring.repository.IEmpleoRepository;
import com.curso.spring.service.IEmpleoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class EmpleoServiceImpl implements IEmpleoService {

    @Autowired
    IEmpleoRepository repository;


    @Override
    public ResponseEntity<?> crearEmpleo(EmpleoDTO empleoDTO) {
        try {

            Empleos empleos = new Empleos();
            empleos.setTitulo(empleoDTO.getTitulo());
            empleos.setEmpresa(empleoDTO.getEmpresa());
            empleos.setSalario(empleoDTO.getSalario());

            Empleos empleoGuardado = new Empleos();

            empleos.setTitulo(empleoDTO.getTitulo());
            empleos.setEmpresa(empleoDTO.getEmpresa());
            empleos.setSalario(empleoDTO.getSalario());

            EmpleoDTO guardadoDTO = new EmpleoDTO();

            empleoGuardado.setEmpleoId(guardadoDTO.getEmpleoId());
            empleoGuardado.setTitulo(guardadoDTO.getTitulo());
            empleoGuardado.setEmpresa(guardadoDTO.getEmpresa());
            empleoGuardado.setSalario(guardadoDTO.getSalario());

            return ResponseEntity.status(HttpStatus.CREATED).body(guardadoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creando empleo");
        }
    }
}
