package com.Broadway.FinalprojectBroadway.Service;

import java.util.List;

import com.Broadway.FinalprojectBroadway.Model.Cart;
import com.Broadway.FinalprojectBroadway.Model.User;

public interface CartService {
	
	void addCart(Cart cart);
	List<Cart> getAllCart();
	void deleteCart(int id);
	List<Cart> getUserById(User user);
    void updateUser(User user);
    Cart getCartById(int id);
}
