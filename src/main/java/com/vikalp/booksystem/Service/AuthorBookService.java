package com.vikalp.booksystem.Service;

import com.vikalp.booksystem.model.Author;
import com.vikalp.booksystem.model.Book;
import com.vikalp.booksystem.repository.AuthorRepository;
import com.vikalp.booksystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class AuthorBookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Book addBook (Book book){
        return bookRepository.save(book);
    }

    public Author addAuthor (Author author){
        return authorRepository.save(author);
    }

    public List<Book> getBooksByAuthor(String text){
        Author a = authorRepository.findByName(text);
        int id = a.getId();

        return bookRepository.findByAuthorId(id);
    }

    public List<Author> getAuthors(String reg){
        return authorRepository.findByNameRegex(reg);
    }
}
