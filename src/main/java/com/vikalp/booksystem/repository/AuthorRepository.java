package com.vikalp.booksystem.repository;

import com.vikalp.booksystem.model.Author;
import com.vikalp.booksystem.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {
    public Author findByName(String text);
    List<Author> findByNameRegex(String reg);
}
