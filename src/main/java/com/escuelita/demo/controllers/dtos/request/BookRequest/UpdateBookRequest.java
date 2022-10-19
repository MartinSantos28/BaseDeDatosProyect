package com.escuelita.demo.controllers.dtos.request.BookRequest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateBookRequest {
    private String tittle;
    private Long year;
}
