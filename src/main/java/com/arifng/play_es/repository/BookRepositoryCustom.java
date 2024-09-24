package com.arifng.play_es.repository;

import com.arifng.play_es.document.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> searchByTitle(String title);
}
