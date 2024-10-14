package com.feignHystrix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.feignHystrix.entity.Book;
import com.feignHystrix.proxy.BookProxy;

@Service(value = "bookService")
@Scope("singleton")
public class BookService implements BookServiceInterface{
	
	@Autowired
	BookProxy bookProxy;

	@Override
	public Book getBookById(int id) {
		return bookProxy.getBookById(id);
	}

	@Override
	public List<Book> getBooks() {
		return bookProxy.getAllBooks();
	}
	

}
