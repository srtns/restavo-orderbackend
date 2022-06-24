package com.example.zomatoApp.zomato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") String id) {
	    try {
	      orderRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @DeleteMapping("/deleteAll")
	  public ResponseEntity<HttpStatus> deleteOrders() {
	    try {
	      orderRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	    @PatchMapping("/updateOrder/{id}")
	    public ResponseEntity<Order> updateOrder(@PathVariable String id, @PathVariable String restname, String resdate,String restime, Integer pernum) {
		try {
			Order _order = orderRepository.findById(id).get();
			_order.setRestName(restname);
			_order.setReservationDate(resdate);
			_order.setReservationTime(restime);
			_order.setPersonNum(pernum);
			return new ResponseEntity<Order>(orderRepository.save(_order), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    }
	    

}
