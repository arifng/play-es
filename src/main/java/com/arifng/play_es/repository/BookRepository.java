package com.arifng.play_es.repository;

import com.arifng.play_es.document.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String>, BookRepositoryCustom {
}
