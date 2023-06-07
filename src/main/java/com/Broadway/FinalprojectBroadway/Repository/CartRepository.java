package com.Broadway.FinalprojectBroadway.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.FinalprojectBroadway.Model.Cart;
import com.Broadway.FinalprojectBroadway.Model.User;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	List<Cart>  findByUser(User user);
}
