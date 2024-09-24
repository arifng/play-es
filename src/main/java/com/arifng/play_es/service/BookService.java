package com.arifng.play_es.service;

import com.arifng.play_es.document.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findById(String id);

    List<Book> searchByTitle(String title);

    Page<Book> findAll(Pageable pageable);
}
