package com.sushma.crudassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CrudAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAssignmentApplication.class, args);
	}
	
	@RequestMapping(path= {"","/"})
	public String bounce() {
		System.out.print("here ya go");
		return "redirect:/languages";
	}
}
