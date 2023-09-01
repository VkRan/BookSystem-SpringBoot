package com.vikalp.booksystem.repository;

import com.vikalp.booksystem.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer> {
    List<Book> findByGenre(String text);
    List<Book> findByGenreAndCopiesAvailableGreaterThan(String text, int count);
    List<Book> findByAuthorId(int id);
}
