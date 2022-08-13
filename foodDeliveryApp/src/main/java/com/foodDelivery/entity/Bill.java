package com.foodDelivery.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
public class Bill {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Integer billId;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    LocalDateTime billDateTime;

    @NotNull
    Integer totalItems;
    @NotNull
    Integer totalCost;
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getBillDateTime() {
		return billDateTime;
	}
	public void setBillDateTime(LocalDateTime billDateTime) {
		this.billDateTime = billDateTime;
	}
	public Integer getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", customer=" + customer + ", billDateTime=" + billDateTime + ", totalItems="
				+ totalItems + ", totalCost=" + totalCost + "]";
	}
	public Bill() {
		super();
	}
	public Bill(Integer billId, Customer customer, LocalDateTime billDateTime, @NotNull Integer totalItems,
			@NotNull Integer totalCost) {
		super();
		this.billId = billId;
		this.customer = customer;
		this.billDateTime = billDateTime;
		this.totalItems = totalItems;
		this.totalCost = totalCost;
	}

    
    
    
}
