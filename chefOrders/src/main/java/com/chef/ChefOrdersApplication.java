package com.chef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ChefOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChefOrdersApplication.class, args);
	}

}
