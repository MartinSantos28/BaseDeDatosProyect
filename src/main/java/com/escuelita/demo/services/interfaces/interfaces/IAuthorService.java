package com.escuelita.demo.services.interfaces.interfaces;

import com.escuelita.demo.controllers.dtos.request.AuthorRequest.CreateAuthorRequest;
import com.escuelita.demo.controllers.dtos.request.AuthorRequest.UpdateAuthorRequest;
import com.escuelita.demo.controllers.dtos.responses.CreateAuthorResponse;
import com.escuelita.demo.controllers.dtos.responses.GetAuthorResponse;
import com.escuelita.demo.controllers.dtos.responses.UpdateAuthorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAuthorService {

    CreateAuthorResponse create(CreateAuthorRequest request);

    GetAuthorResponse get(Long id);

    List<GetAuthorResponse> list();

    UpdateAuthorResponse update(Long id, UpdateAuthorRequest request);

    void delete(Long id);

}
