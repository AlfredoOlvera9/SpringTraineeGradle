package com.curso.spring.service.impl;

import com.curso.spring.dto.CirculoDto;
import com.curso.spring.service.ICirculoService;
import org.springframework.stereotype.Service;

@Service
public class CirculoServiceImpl implements ICirculoService {
    @Override
    public Double calcularAreaCirculo(CirculoDto request) {
        return Math.PI * (request.getRadio() * request.getRadio());
    }
}
