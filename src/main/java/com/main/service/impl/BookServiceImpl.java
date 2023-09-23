package com.main.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.exceptions.ResouceNotFound;
import com.main.models.Book;
import com.main.repository.BookRepository;
import com.main.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;
	
	@Override
	public Book createBook(Book book) {
		String random = UUID.randomUUID().toString();
		book.setId(random);
		Book save = repository.save(book);
		
		return save;
	}

	@Override
	public Book updateBook(Book book,String id) {
		Book find = repository.findById(id).orElseThrow(()-> new ResouceNotFound("Book Not Found On Server"));
		find.setTitle(book.getTitle());
		find.setTypeOfBook(book.getTypeOfBook());
		find.setAuthor(book.getAuthor());
		find.setDate(book.getDate());
		find.setDescription(book.getDescription());
		find.setPrice(book.getPrice());
		Book save = repository.save(find);
		
		return save;
	}

	@Override
	public Book getSingleBook(String id) {
		Book find = repository.findById(id).orElseThrow(()-> new ResouceNotFound("Book Not Found On Server"));
		
		
		return find;
	}

	@Override
	public void deletBook(String id) {
		Book find = repository.findById(id).orElseThrow(()-> new ResouceNotFound("Book Not Found On Server"));
		repository.delete(find);

	}

	@Override
	public List<Book> getAllBooks() {
		
		return repository.findAll();
	}

	
}
