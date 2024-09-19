package com.arifng.play_es.form;

import com.arifng.play_es.document.Author;
import com.arifng.play_es.document.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
    private String title;
    private List<String> authors;
    private String releaseDate;

    public Book toBook() {
        return new Book(null, title, authors.stream().map(Author::new).toList(), releaseDate);
    }
}
