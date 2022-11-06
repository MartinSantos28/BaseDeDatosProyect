package com.escuelita.demo.controllers.dtos;


import com.escuelita.demo.controllers.dtos.request.BookRequest.CreateBookRequest;
import com.escuelita.demo.controllers.dtos.request.BookRequest.UpdateBookRequest;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.CreateBookResponse;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.GetBookResponse;
import com.escuelita.demo.controllers.dtos.responses.BookResponse.UpdateBookResponse;
import com.escuelita.demo.services.interfaces.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("book")
public class BookController {
    @Qualifier("bookServiceImp")
    @Autowired
    private IBookService service;
    @PostMapping
    public CreateBookResponse create(@RequestBody CreateBookRequest request){
        return service.create(request);
    }

    @GetMapping("{id}")
    public GetBookResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<GetBookResponse> list(){
        return  service.list();
    }

    @PutMapping("{id}")
    public UpdateBookResponse update(@PathVariable Long id, @RequestBody UpdateBookRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        service.delete(id);
    }
}
