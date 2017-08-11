package com.sushma.stringassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class StringAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringAssignmentApplication.class, args);
	}
	// 1. Annotation
	@RequestMapping("/")
	// 3. Method that maps to the request route above
	public String hello() {
		return "Hello client! How are you doing?";
	}
	@RequestMapping("/random")
	public String rand() {
		return "Spring Boot is great! So easy to just respond with strings";
	}
}
