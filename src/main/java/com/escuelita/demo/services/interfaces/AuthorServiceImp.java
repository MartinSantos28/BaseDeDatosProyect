package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.request.AuthorRequest.CreateAuthorRequest;
import com.escuelita.demo.controllers.dtos.request.AuthorRequest.UpdateAuthorRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateAuthorResponse;
import com.escuelita.demo.controllers.dtos.responses.GetAuthorResponse;
import com.escuelita.demo.controllers.dtos.responses.UpdateAuthorResponse;
import com.escuelita.demo.entities.Author;
import com.escuelita.demo.repository.IAuthorRepository;
import com.escuelita.demo.services.interfaces.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImp implements IAuthorService {

    @Autowired
    private IAuthorRepository repository;

    @Override
    public CreateAuthorResponse create(CreateAuthorRequest request) {
        Author save=repository.save(from(request));
        return from(save);
    }

    @Override
    public  GetAuthorResponse get(Long id){
        Author author = findOneAndEnsureExist(id);
        return toGetAuthorResponse(author);
    }

    @Override
    public UpdateAuthorResponse update(Long id, UpdateAuthorRequest request){
        Author author = findOneAndEnsureExist(id);
        author.setName(request.getName());
        author.setNationality(request.getNationality());
        return toUpdateAuthorResponse(repository.save(author));
    }

    @Override
    public List<GetAuthorResponse> list(){
        return repository
                .findAll()
                .stream()
                .map(this::toGetAuthorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        repository.delete(findOneAndEnsureExist(id));
    }

    public Author findOneAndEnsureExist(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author Does not Exist"));
    }

    private Author from(CreateAuthorRequest request){
        Author author = new Author();
        author.setId(author.getId());
        author.setName(request.getName());
        author.setNationality(request.getNationality());
        return author;
    }

    private CreateAuthorResponse from(Author author){
        CreateAuthorResponse response = new CreateAuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setNationality(author.getNationality());
        return  response;
    }

    private GetAuthorResponse toGetAuthorResponse(Author author){
        GetAuthorResponse response = new GetAuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setNationality(author.getNationality());
        return response;
    }

    private UpdateAuthorResponse toUpdateAuthorResponse(Author author){
        UpdateAuthorResponse response= new UpdateAuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setNationality(author.getNationality());
        return response;
    }



}
