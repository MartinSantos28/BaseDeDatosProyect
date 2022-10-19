package com.escuelita.demo.controllers.dtos.request.BookRequest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateBookRequest {
    private Long id;
    private String tittle;
    private Long year;
}
