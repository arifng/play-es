package com.arifng.play_es.service;

import com.arifng.play_es.document.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findById(String id);

    List<Book> findByTitle(String title);
}
