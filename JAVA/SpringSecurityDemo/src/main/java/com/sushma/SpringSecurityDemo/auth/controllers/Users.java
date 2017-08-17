package com.sushma.SpringSecurityDemo.auth.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.sushma.SpringSecurityDemo.auth.models.User;
import com.sushma.SpringSecurityDemo.auth.services.UserService;
import com.sushma.SpringSecurityDemo.auth.validator.UserValidator;

@Controller
public class Users {
	private UserService userService;
    private UserValidator userValidator;
	public Users(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping(value= {"/", "/home"})
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUserName(username));
		return "homePage.jsp";
	}
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		}
		userService.saveWithUserRole(user);
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
			if(error != null) {
				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
			}
			if(logout != null) {
				model.addAttribute("logoutMessage", "Logout Successfull!");
			}
			return "loginPage.jsp";
	}
	
	
}
