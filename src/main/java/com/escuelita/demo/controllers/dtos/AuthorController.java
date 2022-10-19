package com.escuelita.demo.controllers.dtos;

import com.escuelita.demo.controllers.dtos.request.AuthorRequest.CreateAuthorRequest;
import com.escuelita.demo.controllers.dtos.request.AuthorRequest.UpdateAuthorRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateAuthorResponse;
import com.escuelita.demo.controllers.dtos.responses.GetAuthorResponse;
import com.escuelita.demo.controllers.dtos.responses.UpdateAuthorResponse;
import com.escuelita.demo.services.interfaces.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("author")
public class AuthorController {


    @Qualifier("authorServiceImp")
    @Autowired
    private IAuthorService service;

    @PostMapping
    public CreateAuthorResponse create(@RequestBody CreateAuthorRequest request){return service.create(request);}

    @GetMapping("{id}")
    public GetAuthorResponse get(@PathVariable Long id){return service.get(id);}

    @GetMapping
    public List<GetAuthorResponse> list(){return service.list();}

    @PutMapping("{id}")
    public UpdateAuthorResponse update(@PathVariable Long id, @PathVariable UpdateAuthorRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("{id}")
    public void   delete(@PathVariable Long id){service.delete(id);}
}
