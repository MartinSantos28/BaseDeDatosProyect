package com.escuelita.demo.repository;

import com.escuelita.demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long> {

}
