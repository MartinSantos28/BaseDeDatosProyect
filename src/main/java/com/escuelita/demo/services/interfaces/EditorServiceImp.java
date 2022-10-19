package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.request.EditorRequest.CreateEditorRequest;
import com.escuelita.demo.controllers.dtos.request.EditorRequest.UpdateEditorRequest;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.CreateEditorResponse;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.GetEditorResponse;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.UpdateEditorResponse;
import com.escuelita.demo.entities.Editor;
import com.escuelita.demo.repository.IEditorRepository;
import com.escuelita.demo.services.interfaces.interfaces.IEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorServiceImp implements IEditorService {
    @Autowired
    private IEditorRepository repository;

    @Override
    public CreateEditorResponse create(CreateEditorRequest request){
        Editor save= repository.save(from(request));
        return  from(save);
    }


    @Override
    public GetEditorResponse get(Long id){
        Editor editor=findOneAndEnsureExist(id);
        return toGetEditorResponse(editor);
    }

    @Override
    public  List<GetEditorResponse> list(){
        return repository
                .findAll()
                .stream()
                .map(this::toGetEditorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateEditorResponse update(Long id, UpdateEditorRequest request){
        Editor editor= findOneAndEnsureExist(id);
        editor.setName(request.getName());
        return toUpdateEditorResponse(repository.save(editor));

    }

    @Override
    public void delete (Long id){
        repository.delete(findOneAndEnsureExist(id));
    }

    private Editor from(CreateEditorRequest request){
        Editor editor = new Editor();
        editor.setId(editor.getId());
        editor.setName(request.getName());
        return editor;
    }

    private CreateEditorResponse from(Editor editor){
        CreateEditorResponse response = new CreateEditorResponse();
        response.setId(editor.getId());
        response.setName(editor.getName());
        return response;

    }

    private GetEditorResponse toGetEditorResponse(Editor editor){
        GetEditorResponse response = new GetEditorResponse();
        response.setId(editor.getId());
        response.setName(editor.getName());
        return response;
    }

    private UpdateEditorResponse toUpdateEditorResponse(Editor editor){
        UpdateEditorResponse response = new UpdateEditorResponse();
        response.setId(editor.getId());
        response.setName(editor.getName());
        return response;
    }

    private Editor findOneAndEnsureExist(Long id){
        return  repository.findById(id).orElseThrow(()-> new RuntimeException("Editor does not exists"));
    }
}
