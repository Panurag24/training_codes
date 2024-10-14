package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.client.entity.Book;

@RestController
@Scope("request")
public class BookClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		
		String url = "http://book-service/books/";
		return restTemplate.getForObject(url + id, Book.class);
	}
}
