package com.masai.UserLogin.Module;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data

public class CustomerDTO {
	
	@NotNull
	@Pattern(regexp="(^$|[0-9]{10})")
    private Integer mobileNo;
	
	@NotNull
	@Pattern(regexp="^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
	private String password;

}
