package com.curso.spring.controller;


import com.curso.spring.dto.CirculoDto;
import com.curso.spring.dto.CuadradoDto;
import com.curso.spring.dto.RectanguloDto;
import com.curso.spring.dto.TrianguloDto;
import com.curso.spring.service.ICirculoService;
import com.curso.spring.service.ICuadradoService;
import com.curso.spring.service.IRectanguloService;
import com.curso.spring.service.ITrianguloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/figuras")
@Slf4j
@CrossOrigin
@Tag(name="Figuras")
public class FigurasController {

    @Autowired
    IRectanguloService rectanguloService;
    @Autowired
    ICirculoService circuloService;
    @Autowired
    ITrianguloService trianguloService;
    @Autowired
    ICuadradoService cuadradoService;





    // @GetMapping("/area-rectangulo/{base}/{altura}")
    @Operation (summary = "Operacion para obtener area de un rectangulo")
    @GetMapping("/area-rectangulo/{base}/{altura}")
    public double calcularRectangulo(@PathVariable @Schema(description = "base del rectangulo",example = "20.50") double base,
                                     @PathVariable @Schema(description = "Altura del rectangulo",example = "20.50")double altura){

        return base * altura;
    }
    @PostMapping("/area-rectangulo")
    public double calculateRectangulo2(@RequestBody RectanguloDto request){

        return rectanguloService.obtenerAreaRectangulo(request);
    }

    @PostMapping("/area-circulo")
    public double calculateCirculo(@RequestBody CirculoDto request){

        return circuloService.calcularAreaCirculo(request);
    }

    @PostMapping("/area-triangulo")
    public double calculateTriangulo(@RequestBody TrianguloDto request){

        return trianguloService.calcularAreaTriangulo(request);
    }

    @PostMapping("/area-cuadrado")
    public double calculateCuadrado(@RequestBody CuadradoDto request){

        return cuadradoService.calcularAreaCuadrado(request);
    }









}
