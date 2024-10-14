package com.bookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Book_Details")
public class Book {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int id;
	
	@Column(name = "book_title")
	private String title;
	
	@Column(name = "book_publisher")
	private String publisher;
	
	@Column(name = "book_isbn")
	private String isbn;
	
	@Column(name = "book_number_of_pages")
	private int numberOfPages;
	
	@Column(name = "book_year")
	private int year;
	
	public Book(String book_title, String book_publisher, String book_isbn, int book_number_of_pages, int book_year) {
	    this.title = book_title;
	    this.publisher = book_publisher;
	    this.isbn = book_isbn;
	    this.numberOfPages = book_number_of_pages;
	    this.year = book_year;
	}
	
}
