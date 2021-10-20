package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;

@Service
public class OrderService extends GeneralService<Order> {
	
	@Override
    public Order update(Order order, long id){
		order.setId(id);
        return repository.saveAndFlush(order);
    }
}