package com.feignHystrix.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.feignHystrix.entity.Book;
import com.feignHystrix.fallbacks.BookFallback;

@FeignClient(name = "book-service", fallback = BookFallback.class)
public interface BookProxy {
	
	@GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBookById(@PathVariable("id") int id);
	
	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks();
	
}
