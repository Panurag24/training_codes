package com.feign.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	private int id;
	
	private String title;
	
	private String publisher;
	
	private String isbn;
	
	private int numberOfPages;
	
	private int year;
}