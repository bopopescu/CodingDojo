package com.sushma.controllerpractice1.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("")
	public String hello(@RequestParam(value="q", required=false) String searchQuery){
		//http://localhost:8080/hello?q=%22what%22
		return "You searched for " + searchQuery;
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
	
	@RequestMapping("/")
	public String ind() {
		return "forward:/index.html";
	}
}
