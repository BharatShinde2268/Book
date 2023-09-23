package com.main.service;

import java.util.List;

import com.main.models.Book;

public interface BookService {
	
	
	// create book
	
	public Book createBook(Book book);
	
	// update book
	
	public Book updateBook(Book book,String id);
	
	// get single book 
	
	public Book getSingleBook(String id);
	
	// delete book
	
	public void deletBook(String id);
	
	// get all book
	
	public List<Book> getAllBooks();
	
	// get book by name
		
	

}
