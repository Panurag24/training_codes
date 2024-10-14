package com.feignHystrix.fallbacks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.feignHystrix.entity.Book;
import com.feignHystrix.proxy.BookProxy;

@Component
public class BookFallback implements BookProxy{

	@Override
	public Book getBookById(int id) {
		return new Book(1, "Default", "Default", "Default", 101, 2001);
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>();
	}

}
