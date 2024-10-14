package com.bookStore.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.Book;

@Repository(value = "bookRepository")
@Scope(value = "singleton")
public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByTitle(String title);
	
	List<Book> findByPublisher(String publisher);
	
	List<Book> findByYear(int year);
	
	
}
