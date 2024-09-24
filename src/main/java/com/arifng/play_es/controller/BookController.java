package com.arifng.play_es.controller;

import com.arifng.play_es.document.Book;
import com.arifng.play_es.form.BookForm;
import com.arifng.play_es.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloW";
    }

    @PostMapping("/books")
    public Book save(@RequestBody BookForm bookForm) {
        return bookService.save(bookForm.toBook());
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @GetMapping("/books")
    public Page<Book> findAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("/books/search")
    public List<Book> search(@RequestParam(required = false) String title) {
        if (title != null) {
            return bookService.searchByTitle(title);
        }
        return Collections.emptyList();
    }
}
