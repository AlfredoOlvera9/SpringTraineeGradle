package com.curso.spring.service;

import com.curso.spring.dto.CuadradoDto;
import com.curso.spring.dto.TrianguloDto;

public interface ICuadradoService {
    Double calcularAreaCuadrado(CuadradoDto request);
}
