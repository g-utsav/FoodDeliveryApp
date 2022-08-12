package com.foodDelivery.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	private LocalDateTime orderDateTime;
	
	private String orderStatus;

	
	
	
	

}
