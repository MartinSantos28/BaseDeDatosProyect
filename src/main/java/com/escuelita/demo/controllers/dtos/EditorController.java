package com.escuelita.demo.controllers.dtos;


import com.escuelita.demo.controllers.dtos.request.EditorRequest.CreateEditorRequest;
import com.escuelita.demo.controllers.dtos.request.EditorRequest.UpdateEditorRequest;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.CreateEditorResponse;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.GetEditorResponse;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.UpdateEditorResponse;
import com.escuelita.demo.services.interfaces.interfaces.IEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("editor")
public class EditorController {

    @Qualifier("editorServiceImp")
    @Autowired
    private IEditorService service;
    @PostMapping
    public CreateEditorResponse create (@RequestBody CreateEditorRequest request){
        return service.create(request);
    }

    @GetMapping("{id}")
    public GetEditorResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<GetEditorResponse> list(){
        return service.list();
    }

    @PutMapping("{id}")
    public UpdateEditorResponse update(@PathVariable Long id, @RequestBody UpdateEditorRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        service.delete(id);
    }

}
