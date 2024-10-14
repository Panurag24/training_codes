package com.mphasis.controller;

import com.mphasis.entity.Book;
import com.mphasis.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookStoreRestController {

    @Autowired
    private BookStoreService bookStoreService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookStoreService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public List<Book> getBookById(@PathVariable Long bookId) {
        return bookStoreService.getBookById(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookStoreService.deleteBookById(bookId);
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> getBooksByTitle(@PathVariable String bookTitle) {
        return bookStoreService.getBooksByTitle(bookTitle);
    }

    @GetMapping("/publisher/{bookPublisher}")
    public List<Book> getBooksByPublisher(@PathVariable String bookPublisher) {
        return bookStoreService.getBooksByPublisher(bookPublisher);
    }

    @GetMapping("/year/{year}")
    public List<Book> getBooksByYear(@PathVariable int year) {
        return bookStoreService.getBooksByYear(year);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookStoreService.addOrUpdateBook(book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookStoreService.addOrUpdateBook(book);
    }
}
