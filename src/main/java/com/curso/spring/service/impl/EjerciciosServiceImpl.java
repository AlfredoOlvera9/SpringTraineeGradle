package com.curso.spring.service.impl;

import com.curso.spring.dto.response.Posts;
import com.curso.spring.service.IEjerciciosService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


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

    @Transactional
    @Override
    public Posts getPosts(int id) {

        ResponseEntity<Posts> resultPost = null;

        try {
            String url = "https://jsonplaceholder.typicode.com/todos/" + id;
            RestTemplate restTemplate = new RestTemplate();

         // resultPost = restTemplate.exchange(url, HttpMethod.GET, null, Posts.class);
            Posts response = restTemplate.getForObject(url,Posts.class);

            resultPost = ResponseEntity.ok(response);


        }catch (Exception e){
            log.error("Error al consumir servico");
        }

        return resultPost.getBody();
    }
}
