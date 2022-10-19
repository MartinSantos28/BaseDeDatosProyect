package com.escuelita.demo.controllers.dtos;

import com.escuelita.demo.controllers.dtos.request.UserRequest.CreateUserRequest;
import com.escuelita.demo.controllers.dtos.request.UserRequest.UpdateUserRequest;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.CreateUserResponse;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.GetUserResponse;
import com.escuelita.demo.controllers.dtos.responses.UserResponse.UpdateUserResponse;
import com.escuelita.demo.services.interfaces.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Qualifier("userServiceImp")
    @Autowired
    private IUserService service;

    @PostMapping
    public CreateUserResponse create(@RequestBody CreateUserRequest request){return service.create(request);}

    @GetMapping("{id}")
    public GetUserResponse get(@PathVariable Long id){return service.get(id);}

    @GetMapping
    public List<GetUserResponse> list(){return  service.list();}

    @PutMapping("{id}")
    public UpdateUserResponse update(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
