package com.foodDelivery.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@Data
@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	private LocalDateTime orderDateTime;

	private String orderStatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", customer=" + customer + ", orderDateTime=" + orderDateTime
				+ ", orderStatus=" + orderStatus + "]";
	}

	public OrderDetails(Integer orderId, Customer customer, LocalDateTime orderDateTime, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDateTime = orderDateTime;
		this.orderStatus = orderStatus;
	}

	public OrderDetails() {
		super();
	}

	
	
	
	

}
