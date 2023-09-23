package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.main.models.Book;


public interface BookRepository extends JpaRepository<Book, String> {
	
	
	// custom finder method
	
@Query("select u FROM Book u WHERE u.title=:t")	
public List<Book> getBookByName(@Param("t") String title);
	
	// get book by author
	@Query("select u FROM Book u WHERE u.author=:a")
	public List<Book> getBookByAuthor(@Param("a") String author);
	
	// get book by type
	@Query("select u FROM Book u WHERE u.typeOfBook=:t")
	public List<Book> getBookByType(@Param("t") String typeOfBook);
	
	
	// get book publishing year
	@Query("select u FROM Book u WHERE u.date=:d")
	public List<Book> getByBookByYear(@Param("d") String date);
	
// @Query("select u FROM Book u")	
//	public List<Book> getAllBooks();

}
