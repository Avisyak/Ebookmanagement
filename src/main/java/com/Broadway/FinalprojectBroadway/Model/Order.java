package com.Broadway.FinalprojectBroadway.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_tbl")
public class Order {
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private double phone;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String payment;
	

}
