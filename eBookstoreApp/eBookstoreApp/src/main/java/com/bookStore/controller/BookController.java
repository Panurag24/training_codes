package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.entity.Book;
import com.bookStore.service.BookServiceInterface;

@RestController
@Scope(value = "request")
public class BookController {
	
	@Autowired
	@Qualifier("bookService")
	BookServiceInterface bookService;
	
	@GetMapping(value = "/books", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public List<Book> getAllBooks() {
		return bookService.findAllBooks();
	}
	
	@PostMapping(value = "/books", produces  = {MediaType.APPLICATION_JSON_VALUE},
									consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping(value = "/books", produces = {MediaType.APPLICATION_JSON_VALUE},
								  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@GetMapping(value = "/books/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookService.findByBookId(id);
	}
	
	
	@DeleteMapping(value = "/books/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable("id") Integer id) {
		 bookService.deleteBookById(id);
	} 
	
	@GetMapping(value = "/books/title/{book_title}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<Book> getBooksByTitle(@PathVariable("book_title") String title){
		return bookService.getAllBooksByTitle(title);
	}
	
	@GetMapping(value = "/books/publisher/{book_publisher}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<Book> getBooksByPublisher(@PathVariable("book_publisher") String publisher){
		return bookService.getAllBooksByPublisher(publisher);
	}
	
	@GetMapping(value = "/books/year", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<Book> getBooksByYear(@RequestParam("year") Integer year){
		return bookService.getAllBooksByYear(year);
	}
	
	
	
	
	
}
