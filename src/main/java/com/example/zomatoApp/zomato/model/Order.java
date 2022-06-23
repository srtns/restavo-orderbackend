package com.example.zomatoApp.zomato.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "orders")


public class Order {
	  @Id
	  private String id;
      private String restName;
	  private String reservationDate;
	  private String reservationTime;
	  private Integer personNum;

	public Order(String restName, String reservationDate, String reservationTime, Integer personNum) {
		
		this.restName = restName;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.personNum = personNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getrestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Integer getPersonNum() {
		return personNum;
	}

	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}
	
	  @Override
	  public String toString() {
	    return "Order [id=" + id + ", restName=" + restName + ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + ", personNum=" + personNum + "]";
	  }

}
