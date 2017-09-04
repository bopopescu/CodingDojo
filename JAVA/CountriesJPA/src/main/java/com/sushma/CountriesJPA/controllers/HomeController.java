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
		model.addAttribute("countries", apiServices.findCountryByLanguage());
		model.addAttribute("totalnumcitiescountry", apiServices.findTotalNumberCitiesCountry());
		model.addAttribute("mexicocities", apiServices.getMexicoCities());
		model.addAttribute("percentagegreaterthan89", apiServices.percentagegreaterthan89());
		System.out.println(apiServices.findSAandpopulation());
		model.addAttribute("SAandGreaterPop", apiServices.findSAandpopulation());
		model.addAttribute("findCMlife", apiServices.findCMlife());
		model.addAttribute("findArgentina", apiServices.findArgentina());
		model.addAttribute("summarizeNumberCountries", apiServices.summarizeNumberCountries());

		return "home.jsp";
	}

}
