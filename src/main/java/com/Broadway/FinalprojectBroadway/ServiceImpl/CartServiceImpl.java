package com.Broadway.FinalprojectBroadway.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.FinalprojectBroadway.Model.Cart;
import com.Broadway.FinalprojectBroadway.Model.User;
import com.Broadway.FinalprojectBroadway.Repository.CartRepository;
import com.Broadway.FinalprojectBroadway.Repository.UserRepository;
import com.Broadway.FinalprojectBroadway.Service.CartService;

@Service
public class CartServiceImpl implements CartService {
    
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public void addCart(Cart cart) {
		
		cartRepo.save(cart);
	}


	@Override
	public List<Cart> getAllCart() {
		
		return cartRepo.findAll();
	}


	@Override
	public void deleteCart(int id) {
		cartRepo.deleteById(id);
		
	}


	@Override
	public List<Cart> getUserById(User user) {
	
		return cartRepo.findByUser(user);
	}


	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}


	@Override
	public Cart getCartById(int id) {
		
		return cartRepo.findById( id).get();
	}


	
}
