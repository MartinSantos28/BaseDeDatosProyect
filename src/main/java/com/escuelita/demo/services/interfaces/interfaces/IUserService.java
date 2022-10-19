package com.escuelita.demo.services.interfaces.interfaces;

import com.escuelita.demo.controllers.dtos.request.UserRequest.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.request.UserRequest.UpdateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.CreateUserResponse;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.GetUserResponse;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.UpdateUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    CreateUserResponse create(CreateUserRequest request);

    GetUserResponse get(Long id);

    List<GetUserResponse> list();

    UpdateUserResponse update(Long id, UpdateUserRequest request);

    void delete(Long id);

}
