package com.codingdojo.driverslicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.services.DriversService;
import com.codingdojo.driverslicense.services.LicenseService;

@Controller
public class DLcontrollers {
	private final DriversService driversService;
	private final LicenseService licenseService;
	
	public DLcontrollers(DriversService driversService, LicenseService licenseService) {
		this.driversService = driversService;
		this.licenseService = licenseService;
	}
	
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
    		System.out.println("qwqwqw");
        return "newPerson.jsp";
    }
    
    @PostMapping("/persons/new")
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
    		if(result.hasErrors()) {
    			return "newPerson.jsp";
    		}else {
    			driversService.addPerson(person);
    			return "redirect:/persons/new";
    		}
    }
    
    
    @RequestMapping("/licenses/new")
    public String newLicense(Model model,@ModelAttribute("license") License license) {
    		List<Person> people = driversService.allPeople();
    		model.addAttribute("allpeople", people);
        return "newLicense.jsp";
    }
    
    @PostMapping("/licenses/new")
    public String createLicense(@ModelAttribute("license") License license, BindingResult result) {
    		if(result.hasErrors()) {
    			return "newLicense.jsp";
    		}else {
    			licenseService.addLicense(license);
    			return "redirect:/licenses/new";
    		}
    }
    
    @RequestMapping("/persons/{id}")
    public String findPerson(Model model,@PathVariable("id") Long id, @ModelAttribute("license") License license) {
    		License lic = licenseService.findLicenseByIndex(id);
    		model.addAttribute("license", lic);
    		System.out.println(lic.getPerson().getFirstName());
    		String name = lic.getPerson().getFirstName() + " " + lic.getPerson().getLastName();
    		model.addAttribute("name", name);
//    		Person gtperson = driversService.getThatPerson(lic.getPerson());
        return "showPerson.jsp";
    }
    
    
}
