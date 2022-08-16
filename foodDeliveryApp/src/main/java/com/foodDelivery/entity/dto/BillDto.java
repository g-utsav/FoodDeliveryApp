package com.foodDelivery.entity.dto;

import com.foodDelivery.entity.Bill;

public class BillDto {

	private Bill bill;
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
	public BillDto(Bill bill, CustomerToken customerToken) {
		super();
		this.bill = bill;
		this.customerToken = customerToken;
	}
	
	public BillDto() {
		
	}
	@Override
	public String toString() {
		return "BillDto [bill=" + bill + ", customerToken=" + customerToken + "]";
	}
	
}
