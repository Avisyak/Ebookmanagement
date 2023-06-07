package com.Broadway.FinalprojectBroadway.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.FinalprojectBroadway.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
