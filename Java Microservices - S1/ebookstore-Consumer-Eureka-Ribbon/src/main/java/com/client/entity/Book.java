package com.client.entity;

import lombok.Data;

@Data
public class Book {
	
	private int id;
	
	private String title;
	
	private String publisher;
	
	private String isbn;
	
	private int numberOfPages;
	
	private int year;
}
