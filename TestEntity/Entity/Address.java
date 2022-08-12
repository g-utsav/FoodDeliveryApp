package com.masai.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer addressId;
	
	@NotNull
	private String buildingName;
	
	private String streetNo;
	
	private String area;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	private String country;
	
	@Size(min=6,max=6)
	private String pincode;
	
	
	


}
