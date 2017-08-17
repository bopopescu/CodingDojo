package com.sushma.CountriesJPA.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sushma.CountriesJPA.services.ApiService;



@Controller
public class HomeController {
	private final ApiService apiServices;

	
	//constructor
	public HomeController(ApiService apiServices) {
		this.apiServices = apiServices;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		System.out.println(apiServices.findCountryByLanguage("Slovene"));
		model.addAttribute("countries", apiServices.findCountryByLanguage("Slovene"));
		return "home.jsp";
	}

}
