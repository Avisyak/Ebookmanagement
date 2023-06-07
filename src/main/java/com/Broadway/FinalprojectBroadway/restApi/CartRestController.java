package com.Broadway.FinalprojectBroadway.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Broadway.FinalprojectBroadway.Model.Cart;
import com.Broadway.FinalprojectBroadway.Service.CartService;

@RestController
public class CartRestController {
    
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/api/list")
	public List<Cart> getAllCartlist() {
		 return cartService.getAllCart(); 
	}
	@GetMapping("/cart/api/{id}")
	public Cart getCartById(@PathVariable int id) {
		 return cartService.getCartById(id);
	}
	
}
