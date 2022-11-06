package com.escuelita.demo.controllers.dtos.responses.BookResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateBookResponse {
    private Long id;
    private String tittle;
    private String year;
}
