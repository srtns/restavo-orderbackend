package com.example.zomatoApp.zomato.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.zomatoApp.zomato.model.User;

public interface userRepository extends MongoRepository<User, String>{
	
	  List<User> findByName(String name);
	  
	  List<User> findBySurname(String surname);
	  
	  

}
