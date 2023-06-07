package com.Broadway.FinalprojectBroadway.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sellbook_tbl")
public class SellBook {
	
	@Id
	@GeneratedValue
	private int id;
	private String bookname;
	private String authorname;
	private int price;
	private int quantity;
	private String photo;
	
	
	
	

}
