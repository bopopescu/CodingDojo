package com.sushma.DojosandNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;

import com.sushma.DojosandNinjas.models.Dojo;
import com.sushma.DojosandNinjas.models.Ninja;
import com.sushma.DojosandNinjas.services.DojoService;
import com.sushma.DojosandNinjas.services.NinjaService;

@Controller
public class DojosNinjas {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosNinjas(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo.jsp";
    }
	
	@PostMapping("/dojos/new")
    public String createnewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if(result.hasErrors()) {
        		return "newDojo.jsp";
        }
        else {
        		dojoService.addDojo(dojo);
        		return "redirect:/dojos/new";
        }
    }

	@RequestMapping("/ninjas/new")
    public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("alldojos", dojoService.allDojos());
        return "newNinja.jsp";
    }
	
	@PostMapping("/ninjas/new")
    public String createnewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if(result.hasErrors()) {
        		return "newNinja.jsp";
        }
        else {
        		ninjaService.addNinja(ninja);
        		return "redirect:/ninjas/new";
        }
    }
	
	@RequestMapping("/dojos/{id}")
    public String findDojo(Model model, @ModelAttribute("dojo") Dojo dojo, @PathVariable("id") Long id) {
		Dojo doj = dojoService.findDojoById(id);
		System.out.println("dsdsds");
		List<Ninja> ninjasfortthisdojo = ninjaService.findNinjas(id);
		System.out.println("wait what");
		for(int i = 0; i < ninjasfortthisdojo.size(); i++) {
			System.out.println(ninjasfortthisdojo.get(i).getFirstName());
		}
		System.out.println(ninjasfortthisdojo);
		model.addAttribute("allninjasforthisdojo", ninjasfortthisdojo);
		model.addAttribute("thatdojo", doj);
        return "showDojo.jsp";
    }
	
	
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax - 1.
	    Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);

	    // total number of pages that we have
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}


}
