package com.sushma.crudassignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.validation.Valid;

import com.sushma.crudassignment.models.Language;
import com.sushma.crudassignment.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesControllers {
	private final LanguageService languageService;
	
	//constructor
	public LanguagesControllers(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/")
	public String bounce() {
		System.out.print("here ya go");
		return "redirect:/languages";
	}
	@RequestMapping("")
	public String languages(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		for(int i =0; i< languages.size(); i++) {
			System.out.println(languages.get(i).getName());
		}
		System.out.println("dsds");
		return "languages.jsp";
	}
	
	@RequestMapping("/{index}")
	public String findLanguagesByIndex(Model model, @PathVariable("index") int index) {
		List<Language> languages = languageService.allLanguages();
		Language language = languageService.findLanguagesByIndex(index);
		model.addAttribute("language", language);
		model.addAttribute("index", index);
		return "languageView.jsp";
	}
	
    @PostMapping("/new")
    public String createBook(@Valid @ModelAttribute("language") Language language, BindingResult result) {
    		if(result.hasErrors()) {
    			return "languages.jsp";
    		}else {
    			languageService.addLanguage(language);
    			return "redirect:/languages";
    		}
    }
    
    @RequestMapping("/edit/{id}")
    public String editLanguage(@PathVariable("id") int id, Model model) {
    		Language language = languageService.findLanguagesByIndex(id);
    		if(language != null) {
    			model.addAttribute("id", id);
    			model.addAttribute("language", language);
    			return "editLanguage.jsp";
    		}
    		else {
    			return "redirect:/languages";
    		}
    }
    
    @PostMapping("/edit/{id}")
    public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
    		if(result.hasErrors()) {
    			return "editLanguage.jsp";
    		}
    		else {
    			languageService.updateLanguage(id, language);
    			return "redirect:/languages";
    		}
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteLanguage(@PathVariable("id") int id) {
    		languageService.removeLanguage(id);
    		return "redirect:/languages";
    }

	
}

