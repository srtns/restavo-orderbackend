package com.example.zomatoApp.zomato.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "users")

public class User {

	@Id
	  private String id;
	  private String name;
	  private String surname;
	  private String email;
	  private String phone;
	  private String restName;
	  private String reservationTime;
	  private Integer tableNum;
	  
 	public User(String name, String surname, String email,String phone, String restName, String reservationTime,
			Integer tableNum) {
 	    
		this.name = name;
		this.surname = surname;

		this.email = email;
		this.phone = phone;
		this.restName = restName;
		this.reservationTime = reservationTime;
		this.tableNum = tableNum;
	} 
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String reservationTime) {
		this.phone = reservationTime;
	}
	
	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Integer getTableNum() {
		return tableNum;
	}

	public void setTableNum(Integer tableNum) {
		this.tableNum = tableNum;
	}
	
	
	  @Override
	  public String toString() {
	    return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", restName=" + restName + ", reservationTime=" + reservationTime + ", tableNum=" + tableNum + "]";
	  }

}
