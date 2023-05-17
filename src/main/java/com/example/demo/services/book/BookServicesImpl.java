package com.example.demo.services.book;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServicesImpl implements BookServices {
    @Override
    public List<Book> findAllBooks() {
        return Arrays.asList(
                new Book("book-1", "Effective Java", 416, "author-1"),
                new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
                new Book("book-3", "Down Under", 436, "author-3")
        );
    }

    @Override
    public Book findByBookId(final String id) {
        return findAllBooks().stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
