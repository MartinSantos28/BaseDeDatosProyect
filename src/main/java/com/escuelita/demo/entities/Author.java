package com.escuelita.demo.entities;

import com.escuelita.demo.entities.pivots.BookAuthor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter @Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "author")
    private List<BookAuthor> bookAuthors;
}
