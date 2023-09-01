package com.vikalp.booksystem.controller;

import com.vikalp.booksystem.Service.AuthorBookService;
import com.vikalp.booksystem.Service.GenreService;
import com.vikalp.booksystem.model.Author;
import com.vikalp.booksystem.model.Book;
import com.vikalp.booksystem.repository.AuthorRepository;
import com.vikalp.booksystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    GenreService genreService;
    @Autowired
    AuthorBookService authorBookService;


    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allBooks")
    @CrossOrigin
    public List<Book> getAllBooks()
    {
        return authorBookService.getAllBooks();
    }

    @GetMapping("/getGenre")
    @CrossOrigin
    public List<Book> search(@RequestParam String genre) {
        return genreService.getByGenre(genre);
    }

    @GetMapping("/getGenreAndCount")
    @CrossOrigin
    public List<Book> genreAndCount(@RequestParam String genre, @RequestParam int copies)
    {
        return genreService.getByGenreAndCopies(genre,copies);
    }

    @PostMapping("/postBook")
    @CrossOrigin
    public Book addBook (@RequestBody Book book){
        return authorBookService.addBook(book);
    }

    @PostMapping("/postAuthor")
    @CrossOrigin
    public Author addAuthor (@RequestBody Author author){
        return authorBookService.addAuthor(author);
    }

    @GetMapping("/getBooksByAuthor")
    @CrossOrigin
    public List<Book> getBooksByAuthor (@RequestParam String author){
        return authorBookService.getBooksByAuthor(author);
    }

    @GetMapping("/regex")
    @CrossOrigin
    public List<Author> getAuthors(@RequestParam String reg){
        return authorBookService.getAuthors(reg);
    }

}
