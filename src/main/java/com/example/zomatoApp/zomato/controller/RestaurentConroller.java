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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.zomatoApp.zomato.repository.RestaurentRepository;

import com.example.zomatoApp.zomato.model.Restaurent;

@CrossOrigin
@RestController
@RequestMapping("/restaurent")

public class RestaurentConroller {
	
	@Autowired
	RestaurentRepository RestaurentRepository;
	 
	  @GetMapping("/get")
	  List<Restaurent> all() {
	    return RestaurentRepository.findAll();
	  }
		
	  @PostMapping("/add")
	  Restaurent newOrder(@RequestBody Restaurent newRestaurent) {
	    return RestaurentRepository.save(newRestaurent);
	  }
	  
	  @GetMapping("/find")
	  List<Restaurent> searchByName(@RequestParam String restName) {
		  return (RestaurentRepository.findByRestName(restName)); 
	    
	  }
	  @DeleteMapping("/name")
	  String delete(@RequestParam String restName, @RequestBody Restaurent rest) {
	      RestaurentRepository.delete(rest);
	      return "Restaurent Deleted";
	  }

	    @PatchMapping("/changeQuota/{id}/{personCount}")
	    public ResponseEntity<Restaurent> updateEmployeePartially(@PathVariable String id, @PathVariable Integer personCount) {
		try {
			Restaurent rest = RestaurentRepository.findById(id).get();
			rest.setPersonCount(personCount);
			return new ResponseEntity<Restaurent>(RestaurentRepository.save(rest), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    }
}


