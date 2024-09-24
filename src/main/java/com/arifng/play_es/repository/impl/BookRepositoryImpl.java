package com.arifng.play_es.repository.impl;

import com.arifng.play_es.document.Book;
import com.arifng.play_es.repository.BookRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.repository.NoRepositoryBean;

import javax.annotation.Nonnull;
import java.util.List;

@NoRepositoryBean
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepositoryCustom {
    @Nonnull private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<Book> searchByTitle(String title) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q ->
                        q.match(m ->
                                m.field("title").query(title)))
                .build();
        return elasticsearchOperations.search(query, Book.class).stream()
                .map(SearchHit::getContent)
                .toList();
    }
}
