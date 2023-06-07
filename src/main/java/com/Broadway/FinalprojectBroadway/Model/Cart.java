package com.Broadway.FinalprojectBroadway.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cart_tbl")
public class Cart {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
    @ManyToOne
	@JoinColumn(name="user_id") 
    private User user;
    
	/* private int quantity; */
	 
}
