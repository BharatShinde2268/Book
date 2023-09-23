package com.main.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
	
	@Id
	private String id;
	private String title;
	private float price;
	private String author;
	private String typeOfBook;
	private String description;
	private String date;
	
	

}
