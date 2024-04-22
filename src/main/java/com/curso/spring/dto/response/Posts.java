package com.curso.spring.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Posts {

    @JsonProperty(value = "user_id")
    private int userid;
    private int id;
    private String title;
    private boolean completed;


}
