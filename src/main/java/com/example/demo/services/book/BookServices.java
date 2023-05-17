package com.example.demo.services.book;

import com.example.demo.model.Book;

import java.util.List;

public interface BookServices {

    List<Book> findAllBooks();

    Book findByBookId(final String id);

}
