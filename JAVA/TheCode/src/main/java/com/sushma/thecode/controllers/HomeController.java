package com.sushma.thecode.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("errors") String errors){
    		System.out.println("in code");
    		System.out.println(errors);
        model.addAttribute("thaterror", errors);
    		return "index.jsp";		   
    }
    
    @RequestMapping("/errors")
    public String errors(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("errors", "You must train harder!");
        return "redirect:/";
    }

    @RequestMapping("/code")
    public String showAssignment(Model model, @RequestParam(value="thatcode") String thatcode){
    		if(thatcode.equals("bushido")) {
    			return "codeView.jsp";
    		}
    		return "redirect:/errors";
    		
    			
		   
    }

}
