package com.curso.spring.service;

import com.curso.spring.dto.response.Posts;

import java.util.List;

public interface IEjerciciosService {

    List <String> getNombres();

    Posts getPosts(int id);

}
