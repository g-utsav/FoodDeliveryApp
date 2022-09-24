package com.foodDelivery.entity.dto;

import com.foodDelivery.entity.Bill;
import com.foodDelivery.entity.Customer;

public class BillDto {

	private Bill bill;
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	private CustomerToken customerToken;
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public CustomerToken getCustomerToken() {
		return customerToken;
	}
	public void setCustomerToken(CustomerToken customerToken) {
		this.customerToken = customerToken;
	}
	public BillDto(Bill bill,Customer customer,CustomerToken customerToken) {
		super();
		this.bill = bill;
		this.customerToken = customerToken;
		this.customer = customer;
	}
	
	public BillDto() {
		
	}
	@Override
	public String toString() {
		return "BillDto [bill=" + bill + ", customer=" + customer + ", customerToken=" + customerToken + "]";
	}
	
	
}
