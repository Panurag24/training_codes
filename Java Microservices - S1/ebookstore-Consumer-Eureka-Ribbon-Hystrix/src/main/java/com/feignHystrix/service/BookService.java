package com.feignHystrix.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feignHystrix.entity.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service(value = "bookService")
@Scope(value = "singleton")
public class BookService implements BookServiceInt{

	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	@HystrixCommand(fallbackMethod = "fallBackMethodForGetBooks")
	public List<Book> getAllBooks() {
		
		String url = "http://book-service/books";
		Book[] books = restTemplate.getForObject(url, Book[].class);
		return Arrays.asList(books);
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallBackMethodForGetBookById")
	public Book getBookById(int id) {
		
		String url = "http://book-service/book/";
		return restTemplate.getForObject(url+id, Book.class);
	}
	
	public Book fallBackMethodForGetBookById(int id) {
		
		return new Book(id, "Default Title", "Default Publisher", "Default ISBN",
						201, 2003);
	}
	
	public List<Book> fallBackMethodForGetBooks(){
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "Default Title 1", "Default Publisher 1", "Default ISBN 1", 301, 2001));
		books.add(new Book(2, "Default Title 2", "Default Publisher 2", "Default ISBN 2", 302, 2002));
		books.add(new Book(3, "Default Title 3", "Default Publisher 3", "Default ISBN 3", 303, 2003));
		books.add(new Book(4, "Default Title 4", "Default Publisher 4", "Default ISBN 4", 304, 2004));
		books.add(new Book(5, "Default Title 5", "Default Publisher 5", "Default ISBN 5", 305, 2005));

		return books;
	}
	
}
