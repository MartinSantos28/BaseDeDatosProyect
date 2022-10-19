package com.escuelita.demo.controllers.dtos.responses.UserResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetUserResponse {

    private Long id;
    private String name;
    private String password;

}
