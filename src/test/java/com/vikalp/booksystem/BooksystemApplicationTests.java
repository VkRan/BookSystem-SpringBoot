package com.vikalp.booksystem;

import com.vikalp.booksystem.Service.AuthorBookService;
import com.vikalp.booksystem.Service.GenreService;
import com.vikalp.booksystem.model.Address;
import com.vikalp.booksystem.model.Author;
import com.vikalp.booksystem.model.Book;
import com.vikalp.booksystem.repository.AuthorRepository;
import com.vikalp.booksystem.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BooksystemApplicationTests {

	@Autowired
	private AuthorBookService authorBookService;

	@Autowired
	private GenreService genreService;

	@MockBean
	private BookRepository bookRepository;

	@MockBean
	private AuthorRepository authorRepository;

	@Test
	public void getAllBooksTest() {
		when(bookRepository.findAll()).thenReturn(Stream.of(new Book(1,200,2,"romance")).collect(Collectors.toList()));
		assertEquals(1,authorBookService.getAllBooks().size());
	}

	@Test
	public void getByGenreTest() {
		String text = "romance";
		when(bookRepository.findByGenre(text)).thenReturn(Stream.of(new Book(1,200,2,"romance"),new Book(2,100,2,"comedy")).collect(Collectors.toList()));
		assertEquals(2,genreService.getByGenre(text).size());
	}

	@Test
	public void addBookTest(){
		Book book = new Book(1,200,2,"romance");
		when(bookRepository.save(book)).thenReturn(book);
		assertEquals(book,authorBookService.addBook(book));
	}

	@Test
	public void addAuthorTest(){
		Author author = new Author(1,"ash",new Address("104A","pune","maharashtra"));
		when(authorRepository.save(author)).thenReturn(author);
		assertEquals(author,authorBookService.addAuthor(author));
	}

	@Test
	public void getAuthorsTest() {
		String text = "as";
		when(authorRepository.findByNameRegex(text)).thenReturn(Stream.of(new Author(1,"ash", new Address("104A","pune","maharashtra"))).collect(Collectors.toList()));
		assertEquals(1,authorBookService.getAuthors(text).size());
	}

	@Test
	public void getByGenreAndCopiesTest() {
		String text = "romance";
		int copies = 100;
		when(bookRepository.findByGenreAndCopiesAvailableGreaterThan(text,copies)).thenReturn(Stream.of(new Book(1,200,2,"romance")).collect(Collectors.toList()));
		assertEquals(1,genreService.getByGenreAndCopies(text,copies).size());
	}
}
