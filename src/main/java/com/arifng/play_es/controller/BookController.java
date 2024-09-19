package com.arifng.play_es.controller;

import com.arifng.play_es.document.Book;
import com.arifng.play_es.form.BookForm;
import com.arifng.play_es.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController("/api")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloW";
    }

    @PostMapping("/book")
    public Book save(@RequestBody BookForm bookForm) {
        return bookService.save(bookForm.toBook());
    }

    @GetMapping("/book/{id}")
    public Book findById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @GetMapping("/book")
    public List<Book> findByTitle(@RequestParam(required = false) String title) {
        if (title != null) {
            return bookService.findByTitle(title);
        }
        return Collections.emptyList();
    }
}
