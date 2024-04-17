package com.curso.spring.service.impl;

import com.curso.spring.dto.CirculoDto;
import com.curso.spring.dto.CuadradoDto;
import com.curso.spring.service.ICirculoService;
import com.curso.spring.service.ICuadradoService;
import org.springframework.stereotype.Service;

@Service
public class CuadradoServiceImpl implements ICuadradoService {

    @Override
    public Double calcularAreaCuadrado(CuadradoDto request) {

        return request.getLado() * request.getLado();
    }
}
