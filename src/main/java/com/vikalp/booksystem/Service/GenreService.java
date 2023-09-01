package com.vikalp.booksystem.Service;

import com.vikalp.booksystem.model.Book;
import com.vikalp.booksystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getByGenre(String text)
    {
        return bookRepository.findByGenre(text);
    }

    public List<Book> getByGenreAndCopies(String text,int count)
    {
        return bookRepository.findByGenreAndCopiesAvailableGreaterThan(text, count);
    }
}
