package com.escuelita.demo.controllers.dtos.request.UserRequest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserRequest {

    private Long id;
    private String name;
    private String password;

}
