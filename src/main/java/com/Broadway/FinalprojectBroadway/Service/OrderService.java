package com.Broadway.FinalprojectBroadway.Service;

import java.util.List;

import com.Broadway.FinalprojectBroadway.Model.Order;

public interface OrderService {
	
	void addOrder(Order order);
	List<Order> getAllOrder();

}
