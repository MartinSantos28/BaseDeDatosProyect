package com.escuelita.demo.repository;

import com.escuelita.demo.entities.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEditorRepository  extends JpaRepository<Editor, Long> {
}
