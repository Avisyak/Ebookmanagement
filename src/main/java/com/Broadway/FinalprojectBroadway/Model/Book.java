package com.Broadway.FinalprojectBroadway.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="book_table")
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	private String bname;
	private String aname;
	private String price;
	private String category;
	private String photo;

}
