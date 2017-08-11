package com.sushma.portfolioassignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String ind() {
		return "forward:/index.html";
	}

	@RequestMapping("/projects")
	public String proj() {
		return "forward:/proj.html";
	}

	@RequestMapping("/me")
	public String me() {
		return "forward:/mine.html";
	}


}
