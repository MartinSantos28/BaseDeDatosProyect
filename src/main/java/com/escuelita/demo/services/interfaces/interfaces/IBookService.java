package com.escuelita.demo.services.interfaces.interfaces;


import com.escuelita.demo.controllers.dtos.request.BookRequest.CreateBookRequest;
import com.escuelita.demo.controllers.dtos.request.BookRequest.UpdateBookRequest;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.CreateBookResponse;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.GetBookResponse;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.UpdateBookResponse;

import java.util.List;


public interface IBookService {

    CreateBookResponse create(CreateBookRequest request);

    GetBookResponse get(Long id);

    List<GetBookResponse> list();

    UpdateBookResponse update(Long id, UpdateBookRequest request);

    void delete(Long id);

    void updateBookCover(String bookCoverUrl, Long idBook);
}
