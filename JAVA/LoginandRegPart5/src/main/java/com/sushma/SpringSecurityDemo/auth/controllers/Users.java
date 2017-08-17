package com.sushma.SpringSecurityDemo.auth.controllers;

import java.security.Principal;
import java.util.Date;

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
		Date now = new Date();
		System.out.println("sdsd");
		model.addAttribute("date", now);
		model.addAttribute("currentUser", userService.findByUserName(username));
		User thatuser = userService.findByUserName(username);

	    if( thatuser.getRoles().toString().equals(userService.findRoleByName("ROLE_USER").toString())) {
            return "homePage.jsp";
    }else {

            return "redirect:/admin";
    }
	}
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginPage.jsp";
		}
		userService.saveWithUserRole(user);
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
			if(error != null) {
				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
			}
			if(logout != null) {
				model.addAttribute("logoutMessage", "Logout Successfull!");
			}
			return "loginPage.jsp";
	}
	
    // NEW 
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUserName(username));
        model.addAttribute("allusers", userService.findallUsers());
        model.addAttribute("roleadmin", userService.findRoleByName("ROLE_ADMIN"));
        model.addAttribute("roleuser", userService.findRoleByName("ROLE_USER"));
        return "adminPage.jsp";
    }
    
    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
    		userService.removePerson(id);
    		return "redirect:/admin";
    }

    @RequestMapping("/makeadmin/{id}")
    public String makePersonAdmin(@PathVariable("id") Long id) {
    		User getuser = userService.FindOneUser(id);
//			System.out.println(category.getName());
//			System.out.println(category.getId());
//			System.out.println("products");
//			categoryService.addProductToCategory(prodid, categoryId);
			userService.saveUserWithAdminRole(getuser);
			//2 is ROLE_ADMIN
//    		getuser.setRoles();
    		//getuser.getRoles().get(0).setName("ROLE_ADMIN");
    		return "redirect:/admin";
    }

    
}
