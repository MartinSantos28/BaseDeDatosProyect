package com.escuelita.demo.services.interfaces.interfaces;


import com.escuelita.demo.controllers.dtos.request.EditorRequest.CreateEditorRequest;
import com.escuelita.demo.controllers.dtos.request.EditorRequest.UpdateEditorRequest;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.CreateEditorResponse;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.GetEditorResponse;
import com.escuelita.demo.controllers.dtos.responses.EditorResponse.UpdateEditorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEditorService {
    CreateEditorResponse create(CreateEditorRequest request);

    GetEditorResponse get(Long id);

    List<GetEditorResponse> list();

    UpdateEditorResponse update (Long id, UpdateEditorRequest request);

    void delete (Long id);
}