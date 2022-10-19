package com.escuelita.demo.controllers.dtos.request.AuthorRequest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateAuthorRequest {

    private Long id;
    private String name;
    private String nationality;

}
