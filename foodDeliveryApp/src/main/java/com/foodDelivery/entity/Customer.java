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


//@Data
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

	public Integer getCustomrId() {
		return customrId;
	}

	public void setCustomrId(Integer customrId) {
		this.customrId = customrId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customrId=" + customrId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", email=" + email + ", cart=" + cart
				+ ", address=" + address + "]";
	}

	public Customer(Integer customrId, @NotNull String firstName, @NotNull String lastName,
			@NotNull @Min(15) Integer age, @NotNull String gender, @Size(min = 10, max = 10) Long mobileNumber,
			@Email String email, Cart cart, Address address) {
		super();
		this.customrId = customrId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.cart = cart;
		this.address = address;
	}

	public Customer() {
		super();
	}
	
	
	

}
