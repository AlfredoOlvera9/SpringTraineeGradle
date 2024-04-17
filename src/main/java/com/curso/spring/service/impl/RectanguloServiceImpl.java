package com.curso.spring.service.impl;

import com.curso.spring.dto.RectanguloDto;
import com.curso.spring.service.IRectanguloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RectanguloServiceImpl implements IRectanguloService {
    @Override
    public Double obtenerAreaRectangulo(RectanguloDto request) {
        return request.getBase() * request.getAltura();
    }
}
