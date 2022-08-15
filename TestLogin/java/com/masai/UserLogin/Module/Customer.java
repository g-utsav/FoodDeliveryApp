package com.masai.UserLogin.Module;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer customrId;
	
	@NotNull
	@Pattern(regexp="^[A-Z][a-z]*")
	private String name;
	
	@NotNull
	@Pattern(regexp="(^$|[0-9]{10})")
    private Integer mobileNo;
	
	@NotNull
	@Pattern(regexp="^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
	private String password;
	
	
    @Email
    @NotNull
	private String email;
	
	

}
