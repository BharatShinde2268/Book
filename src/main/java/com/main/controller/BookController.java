package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.Book;
import com.main.repository.BookRepository;
import com.main.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private BookService service;
	
	
	// create 
	@PostMapping("/create")
	public Book createBook(@RequestBody Book book)
	{
		Book createBook = service.createBook(book);
		return createBook;
	}
	
	// update 
	@PutMapping("/update/{id}")
	public Book updateBook(@RequestBody Book book,String id)
	{
		Book updateBook = service.updateBook(book, id);
		return updateBook;
	}
	
	// delete
	@DeleteMapping("/delete/{id}")
	public void delteBook(@PathVariable String id)
	{
		service.deletBook(id);
		System.out.println("Book Deleted Successfull...");
	}
	// get single 
	@GetMapping("/single/{id}")
	public Book getSingleBook(@PathVariable String id)
	{
		Book singleBook = service.getSingleBook(id);
		return singleBook;
	}
	
	// get all 
	@GetMapping("/all")
	public List<Book> getAllBooks()
	{
		List<Book> allBooks = service.getAllBooks();
		return allBooks;
	}
	
	
	// get by name
	@GetMapping("/name/{title}")
	public List<Book> getBookByName(@PathVariable String title)
	{
		List<Book> bookByName = repository.getBookByName(title);
		return bookByName;
	}
	
	// get by author
	
	@GetMapping("/author/{author}")
	public List<Book> getBookByAuthor(@PathVariable String author)
	{
		List<Book> bookByAuthor = repository.getBookByAuthor(author);
		return bookByAuthor;
	}
	
	// get by type
	
	@GetMapping("/type/{typeOfBook}")
	public List<Book> getBookByType(@PathVariable String typeOfBook)
	{
		List<Book> bookByType = repository.getBookByType(typeOfBook);
		return bookByType;
	}
	// get by pushlishing year
	@GetMapping("/year/{date}")
	public List<Book> getBookByYear(@PathVariable String date)
	{
		List<Book> byBookByYear = repository.getByBookByYear(date);
		return byBookByYear;
	}
	
	
}
