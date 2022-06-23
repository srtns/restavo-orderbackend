package com.example.zomatoApp.zomato.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.zomatoApp.zomato.model.User;
import com.example.zomatoApp.zomato.repository.userRepository;
import com.example.zomatoApp.zomato.repository.RestaurentRepository;

@CrossOrigin
@RestController
@RequestMapping("/users")

public class userController {
	
	@Autowired
	userRepository userRepository;
	RestaurentRepository RestaurentRepository;
	
	  @GetMapping("/get")
	  public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
	    try {
	      List<User> users = new ArrayList<User>();

	      if (name == null)
	        userRepository.findAll().forEach(users::add);
	      else
	        userRepository.findByName(name).forEach(users::add);

	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  @GetMapping("/get/{id}")
	  public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
	    Optional<User> userData = userRepository.findById(id);

	    if (userData.isPresent()) {
	      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PostMapping("/add")
	  public ResponseEntity<User> createUser(@RequestBody User user) {
	    try {
	      User _user = userRepository.save(new User(user.getName(), user.getSurname(), user.getEmail(), user.getPhone(), user.getRestName(), user.getReservationTime(), user.getTableNum()));
	      return new ResponseEntity<>(_user, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/update/{id}")
	  public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
	    Optional<User> userData = userRepository.findById(id);

	    if (userData.isPresent()) {
	      User _user = userData.get();
	      _user.setName(user.getName());
	      _user.setSurname(user.getSurname());
	      _user.setEmail(user.getEmail());
	      _user.setPhone(user.getPhone());
	      _user.setRestName(user.getRestName());
	      _user.setReservationTime(user.getReservationTime());
	      _user.setTableNum(user.getTableNum());
	      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PutMapping("/saveOrder/{id}")
	  public ResponseEntity<User> updateOrderUser(@PathVariable("id") String id, @RequestBody User user) {
	    Optional<User> userData = userRepository.findById(id);
	    
	    if (userData.isPresent()) {
	      User _user = userData.get();
	      _user.setRestName(user.getRestName());
	      _user.setReservationTime(user.getReservationTime());
	      _user.setTableNum(user.getTableNum());
	      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
	    try {
	      userRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping("/deleteAll")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
	    try {
	      userRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  
	  @GetMapping("/search")
	  List<User> searchByName(@RequestParam String name) {
	      return userRepository.findByName(name);
	  }
	  

	  

	/*  @GetMapping("/users/{}")
	  public ResponseEntity<List<User>> findByName() {
	    try {
	      List<User> users = userRepository.findByName(name);

	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }*/

	  
	  
}
