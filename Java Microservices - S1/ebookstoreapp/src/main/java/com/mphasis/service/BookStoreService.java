package com.mphasis.service;

import com.mphasis.entity.Book;
import com.mphasis.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreService {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public List<Book> getAllBooks() {
        return bookStoreRepository.findAll();
    }

    public List<Book> getBookById(Long bookId) {
        return bookStoreRepository.findAllByBookId(bookId);
    }

    public void deleteBookById(Long bookId) {
        bookStoreRepository.deleteByBookId(bookId);
    }

    public List<Book> getBooksByTitle(String bookTitle) {
        return bookStoreRepository.findByBookTitle(bookTitle);
    }

    public List<Book> getBooksByPublisher(String bookPublisher) {
        return bookStoreRepository.findByBookPublisherLike("%" + bookPublisher + "%");
    }

    public List<Book> getBooksByYear(int year) {
        return bookStoreRepository.findByYear(year);
    }
    
    public Book addOrUpdateBook(Book book) {
        return bookStoreRepository.save(book);
    }
}
