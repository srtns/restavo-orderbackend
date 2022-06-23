package com.example.zomatoApp.zomato.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.zomatoApp.zomato.model.Restaurent;


public interface RestaurentRepository extends MongoRepository<Restaurent, String> {
	
    List<Restaurent> findByRestName(String restName);

}
