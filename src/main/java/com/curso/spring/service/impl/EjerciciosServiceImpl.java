package com.curso.spring.service.impl;

import com.curso.spring.service.IEjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EjerciciosServiceImpl implements IEjerciciosService {
    @Override
    public List<String> getNombres() {
        log.info("Entro a get nombre");
        List<String> response = new ArrayList<>();
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Cesar");
        listaNombres.add("Alfredo");
        listaNombres.add("Alfonso");
        listaNombres.add("Ruben");

    /*    for (String nombre: listaNombres){
            if (nombre.contains("o") || nombre.contains("O")){
                log.info("Entro al if");
                response.add(nombre);
            }
          }
     */

       /* int index = 0;

        while(index < listaNombres.size()) {
            String nombre = listaNombres.get(index);
            if (nombre.toLowerCase().contains("o")){
                response.add(nombre);
            }
            index ++;
        }

        */

       /* int index = 0;

        do {
            String nombre = listaNombres.get(index);
            if (nombre.toLowerCase().contains("o")){
                response.add(nombre);
            }
            index ++;
        }while (index < listaNombres.size());

        */

        response = listaNombres.stream()
                .filter(nombre -> nombre.toLowerCase().contains("e"))
                .collect(Collectors.toList());

        return response;
    }
}
