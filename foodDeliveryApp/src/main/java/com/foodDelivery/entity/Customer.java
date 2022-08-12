package com.foodDelivery.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer customrId;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Min(15)
	private Integer age;
	
	@NotNull
	private String gender;
	
	@Size(min=10,max=10)
    private Long mobileNumber;
	
	@Email
	private String email;
	
	//@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	//@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	

}
