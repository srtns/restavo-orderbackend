package com.example.zomatoApp.zomato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zomatoApp.zomato.model.Order;
import com.example.zomatoApp.zomato.repository.orderRepository;

@CrossOrigin
@RestController
@RequestMapping("/orders")

public class orderController {
	@Autowired
	orderRepository orderRepository;
	 
	  @GetMapping("/get")
	  List<Order> all() {
	    return orderRepository.findAll();
	  }
		
	  @PostMapping("/add")
	  Order newOrder(@RequestBody Order newOrder) {
	    return orderRepository.save(newOrder);
	  }

	  
	    

}
