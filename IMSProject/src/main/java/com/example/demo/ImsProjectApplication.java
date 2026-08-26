package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Inventory Management System",
	        version = "1.0",
	        description = "REST APIs for managing products, inventory and stock operations"
	    )
	)
public class ImsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsProjectApplication.class, args);
	}

}
