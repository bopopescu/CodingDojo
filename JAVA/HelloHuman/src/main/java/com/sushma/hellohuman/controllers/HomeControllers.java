package com.sushma.hellohuman.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
//@RequestMapping("/hello")
public class HomeControllers {
    @RequestMapping(path="/login", method=RequestMethod.POST)

	    public String index(Model model, @RequestParam(value="name", required=false) String searchQuery) {
		   if(searchQuery == null) {
			   model.addAttribute("getdate", "human");
			   return "home.jsp";
		   }
		   else {
			   model.addAttribute("getdate", searchQuery);
			   return "home.jsp";
		   }
	   }
		   


}
