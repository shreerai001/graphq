package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.services.author.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private final AuthorServices authorServices;

    @Autowired
    public AuthorController(final AuthorServices authorServices) {
        this.authorServices = authorServices;
    }

    @SchemaMapping
    public Author author(final Book book) {
        return authorServices.getById(book.authorId());
    }
}
