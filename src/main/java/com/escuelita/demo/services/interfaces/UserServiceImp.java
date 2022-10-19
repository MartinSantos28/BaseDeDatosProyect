package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.request.UserRequest.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.request.UserRequest.UpdateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.CreateUserResponse;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.GetUserResponse;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.UpdateUserResponse;
import com.escuelita.demo.entities.User;
import com.escuelita.demo.repository.IUserRepository;
import com.escuelita.demo.services.interfaces.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp  implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public CreateUserResponse create(CreateUserRequest request){
        User save = repository.save(from(request));
        return from(save);
    }

    @Override
    public GetUserResponse get(Long id){
        User user = findOneAndEnsureExist(id);
        return toGetUserResponse(user);
    }

    @Override
    public List<GetUserResponse> list(){
        return repository
                .findAll()
                .stream()
                .map(this::toGetUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateUserResponse update(Long id, UpdateUserRequest request){
        User user = findOneAndEnsureExist(id);
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        return toUpdateUserResponse(repository.save(user));
    }

    @Override
    public void delete(Long id){
        repository.delete(findOneAndEnsureExist(id));
    }

    public User findOneAndEnsureExist(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Does not Exist"));
    }

    private User from(CreateUserRequest request){
        User user = new User();
        user.setId(user.getId());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        return user;
    }

    private CreateUserResponse from(User user){
        CreateUserResponse response= new CreateUserResponse();
        response.setName(user.getName());
        response.setPassword(user.getPassword());
        return  response;
    }

    private GetUserResponse toGetUserResponse(User user){
        GetUserResponse response= new GetUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setPassword(user.getPassword());
        return response;
    }

    private UpdateUserResponse toUpdateUserResponse(User user){
        UpdateUserResponse response = new UpdateUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setPassword(user.getPassword());
        return response;
    }
}
