package com.curso.spring.service.impl;

import com.curso.spring.dto.TrianguloDto;
import com.curso.spring.service.ITrianguloService;
import org.springframework.stereotype.Service;

@Service
public class TrianguloServiceImpl implements ITrianguloService {
    @Override
    public Double calcularAreaTriangulo(TrianguloDto request) {
        return (request.getBase()*request.getAltura()) / 2;
    }
}
