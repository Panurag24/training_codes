package com.feignHystrix.service;

import java.util.List;

import com.feignHystrix.entity.Book;

public interface BookServiceInt {
	
	public List<Book> getAllBooks();
	
	public Book getBookById(int id);
	
}
