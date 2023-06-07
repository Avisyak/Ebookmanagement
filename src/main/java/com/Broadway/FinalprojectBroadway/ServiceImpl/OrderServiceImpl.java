package com.Broadway.FinalprojectBroadway.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.FinalprojectBroadway.Model.Order;
import com.Broadway.FinalprojectBroadway.Repository.OrderRepository;
import com.Broadway.FinalprojectBroadway.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    
	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public void addOrder(Order order) {
		
		orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrder() {
		
		return orderRepo.findAll();
	}

	

}
