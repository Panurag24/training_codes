package com.feignHystrix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.feignHystrix.entity.Book;
import com.feignHystrix.service.BookServiceInterface;

@RestController
@Scope("request")
public class BookController {
	
	@Autowired
	@Qualifier("bookService")
	BookServiceInterface bookService;
	
	@GetMapping("/get-book/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/get-books")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
}
