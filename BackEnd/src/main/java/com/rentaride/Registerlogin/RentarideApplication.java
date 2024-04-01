package com.rentaride.Registerlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RentarideApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentarideApplication.class, args);
	}

}
