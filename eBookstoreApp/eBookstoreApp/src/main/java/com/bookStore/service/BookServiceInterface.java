package com.bookStore.service;

import java.util.List;

import com.bookStore.entity.Book;

public interface BookServiceInterface {
	
	public Book addBook(Book book);
	
	public Book updateBook(Book book);
	
	public List<Book> findAllBooks();
	
	public Book findByBookId(int id);
	
	public void deleteBookById(int id);
	
	public List<Book> getAllBooksByTitle(String title);
	
	public List<Book> getAllBooksByPublisher(String publisher);
	
	public List<Book> getAllBooksByYear(int year);
}
