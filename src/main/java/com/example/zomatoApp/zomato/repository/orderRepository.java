package com.example.zomatoApp.zomato.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.zomatoApp.zomato.model.Order;

public interface orderRepository extends MongoRepository<Order, String>{
	

}
