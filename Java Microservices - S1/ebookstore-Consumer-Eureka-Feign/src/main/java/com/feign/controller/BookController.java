package com.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.feign.entity.Book;
import com.feign.proxy.BookServiceProxy;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Scope("request")
public class BookController {
	
	@Autowired
	private BookServiceProxy bookServiceProxy;
	
	@GetMapping("/get-Book/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookServiceProxy.getBookById(id);
	}
	
	@GetMapping("/get-books")
	public List<Book> getBooks() {
		return bookServiceProxy.getAllBooks();
	}
	
	
}
