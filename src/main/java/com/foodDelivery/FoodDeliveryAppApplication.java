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
		String str = "This is Food Delivery REST-API for the reference of the API visit https://github.com/g-utsav/FoodDeliveryApp \nYou can use\n\t /address \n\t /admin \n\t /bill \n\t /cart \n\t /category \n\t /customer \n\tAnd Many more URL extensions visit github for reference";
      		return str;
   	}

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryAppApplication.class, args);
	}

}
