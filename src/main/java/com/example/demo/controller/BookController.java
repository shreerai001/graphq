package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.services.book.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookServices bookServices;

    @Autowired
    public BookController(final BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @QueryMapping
    public Book bookById(final @Argument String id) {
        return bookServices.findByBookId(id);
    }


    @SchemaMapping(typeName = "Mutation", field = "addBook")
    public String addBook(
            @Argument String author,
            @Argument String name,
            @Argument String publisher,
            @Argument Double price) {
        Book book = new Book(author, name, 1, publisher);
        return null;
    }

    @SchemaMapping(typeName = "Mutation", field = "addTest")
    public String addTest(@Argument String name) {
        System.out.println(name);
        return "";
    }
}
