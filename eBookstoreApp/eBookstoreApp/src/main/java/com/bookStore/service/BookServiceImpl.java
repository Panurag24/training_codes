package com.bookStore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service(value = "bookService")
@Scope(value = "singleton")
public class BookServiceImpl implements BookServiceInterface{
	
	@Autowired
	@Qualifier(value = "bookRepository")
	BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findByBookId(int id) {
	 
		Optional<Book> book =bookRepository.findById(id);
		if(book.get() != null)
			return book.get();
		else
			return new Book();
	}

	@Override
	public void deleteBookById(int id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> getAllBooksByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Book> getAllBooksByPublisher(String publisher) {
		return bookRepository.findByPublisher(publisher);
	}

	@Override
	public List<Book> getAllBooksByYear(int year) {
		return bookRepository.findByYear(year);
	}

}
