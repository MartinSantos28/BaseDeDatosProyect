package com.escuelita.demo.services.interfaces;


import com.escuelita.demo.controllers.dtos.request.BookRequest.CreateBookRequest;
import com.escuelita.demo.controllers.dtos.request.BookRequest.UpdateBookRequest;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.CreateBookResponse;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.GetBookResponse;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.UpdateBookResponse;
import com.escuelita.demo.entities.Book;
import com.escuelita.demo.repository.IBookRepository;
import com.escuelita.demo.services.interfaces.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements IBookService {
    @Autowired
    private IBookRepository repository;

    @Override
    public CreateBookResponse create(CreateBookRequest request) {
        Book save = repository.save(from(request));
        return from(save);
    }

    @Override
    public GetBookResponse get(Long id) {
        Book book= findOneAndEnsureExist(id);
        return toGetBookResponse(book);
    }

    @Override
    public List<GetBookResponse> list() {
    return repository
                .findAll()
                .stream()
                .map(this::toGetBookResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {repository.delete(findOneAndEnsureExist(id));}

    @Override
    public UpdateBookResponse update(Long id, UpdateBookRequest request){
        Book book = findOneAndEnsureExist(id);
        book.setYear(request.getYear());
        book.setTittle(request.getTittle());
        return toUpdateBookResponse(repository.save(book));
    }

    public Book findOneAndEnsureExist(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("The book does not exist"));
    }

   private Book from(CreateBookRequest request){
        Book book = new Book();
        book.setId(book.getId());
        book.setTittle(request.getTittle());
        book.setYear(request.getYear());
        return book;
   }

   private CreateBookResponse from(Book book){
        CreateBookResponse response = new CreateBookResponse();
        response.setId(book.getId());
        response.setTittle(book.getTittle());
        response.setYear(book.getYear());
        return response;
   }

   private GetBookResponse toGetBookResponse(Book book){
        GetBookResponse response = new GetBookResponse();
        response.setId(book.getId());
        response.setTittle(book.getTittle());
        response.setYear(book.getYear());
        return response;
   }

   private UpdateBookResponse toUpdateBookResponse(Book book ){
       UpdateBookResponse response = new UpdateBookResponse();
       response.setId(book.getId());
       response.setTittle(book.getTittle());
       response.setYear(book.getYear());
       return response;

   }

}
