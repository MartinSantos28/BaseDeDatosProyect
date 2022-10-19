package com.escuelita.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateAuthorResponse {

    private Long id;
    private String name;
    private String nationality;
}
