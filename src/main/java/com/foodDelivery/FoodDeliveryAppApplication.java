package com.foodDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class FoodDeliveryAppApplication {

   	@RequestMapping("/")
    	@ResponseBody
    	String home() {
      		return "Hello World!";
   	}

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryAppApplication.class, args);
	}

}
