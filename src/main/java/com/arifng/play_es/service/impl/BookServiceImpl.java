package com.arifng.play_es.service.impl;

import com.arifng.play_es.document.Book;
import com.arifng.play_es.repository.BookRepository;
import com.arifng.play_es.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
