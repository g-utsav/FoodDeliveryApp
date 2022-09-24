package com.foodDelivery.entity.dto;

import com.foodDelivery.entity.OrderDetails;

public class OrderDetailsDto {

	private OrderDetails orderdetails;
	private CustomerToken customerToken;
	
	
	
	public OrderDetailsDto() {
		super();
	}
	public OrderDetailsDto(OrderDetails orderdetails, CustomerToken customerToken) {
		super();
		this.orderdetails = orderdetails;
		this.customerToken = customerToken;
	}
	public OrderDetails getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(OrderDetails orderdetails) {
		this.orderdetails = orderdetails;
	}
	public CustomerToken getCustomerToken() {
		return customerToken;
	}
	public void setCustomerToken(CustomerToken customerToken) {
		this.customerToken = customerToken;
	}
	@Override
	public String toString() {
		return "OrderDetailsDto [orderdetails=" + orderdetails + ", customerToken=" + customerToken + "]";
	}
	
	
}
