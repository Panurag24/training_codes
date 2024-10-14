package com.feignHystrix.service;
import java.util.List;

import com.feignHystrix.entity.Book;

public interface BookServiceInterface {
	
	public Book getBookById(int id);
	
	public List<Book> getBooks();
}
