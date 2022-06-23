package com.example.zomatoApp.zomato.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurent")

public class Restaurent {


	@Id
	  private String id;
	  private String restName;
	  private String availableTime;
	  private Integer personCount;
	  
	  public Restaurent(String restName, String availableTime, Integer personCount) {
		super();
		this.restName = restName;
		this.availableTime = availableTime;
		this.personCount = personCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public Integer getPersonCount() {
		return personCount;
	}

	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
	}	  
	  
	  
	 
}
