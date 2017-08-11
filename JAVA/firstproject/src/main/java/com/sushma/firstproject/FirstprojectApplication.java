package com.sushma.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	// 1. Annotation
	@RequestMapping("/")
	// 3. Method that maps to the request route above
	public String hello() {
		return "Hello World dsds";
	}
	@RequestMapping("/what")
	public String yeah() {
		return "What";
	}
}
