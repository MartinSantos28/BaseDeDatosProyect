package com.escuelita.demo.entities;

import com.escuelita.demo.entities.pivots.BookAuthor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name= "books")
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String tittle;
    @Column (nullable = false)
    private String year;
    private String bookCover;


    @OneToMany(mappedBy = "book")
    private List<BookAuthor> bookAuthors;

    @OneToMany
    private List<Borrower> borrower;

    @ManyToOne
    @JoinColumn(name = "id_editor")
    private Editor editor;
}
