package com.sushma.BeltExam.controllers;

import java.security.Principal;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sushma.BeltExam.services.UserService;
import com.sushma.BeltExam.services.PackageService;

import com.sushma.BeltExam.validator.UserValidator;
import com.sushma.BeltExam.models.User;
import com.sushma.BeltExam.models.GetPackage;

@Controller
public class HomeController {
	private UserService userService;
	private UserValidator userValidator;
	private PackageService packageService;
	public HomeController(UserValidator userValidator, PackageService packageService, UserService userService) {
		this.userValidator = userValidator;
		this.userService = userService;
		this.packageService = packageService;
	}
	
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("getuser") User user, BindingResult result, Model model) {

		return "registrationPage.jsp";
	}
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("getuser") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginPage.jsp";
		}
		// userService.saveUserWithAdminRole(user); -> FOR ADMIN ROLE!
		userService.saveWithUserRole(user);
		
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("getuser") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {

			if(error != null) {
				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
			}
			if(logout != null) {
				model.addAttribute("logoutMessage", "Logout Successfull!");
			}
			return "loginPage.jsp";
	}
	
	@RequestMapping(value= {"/", "/home"})
	public String home(Principal principal, Model model, @ModelAttribute("getuser") User getuser) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUserName(username));
		User thatuser = userService.findByUserName(username);
		String gettingallpackages[] = {"Basic ($10.00)", "Premium ($100.00)", "Current Special"};
		model.addAttribute("gettingallpackages", packageService.findallPackages());
	    if( thatuser.getRoles().toString().equals(userService.findRoleByName("ROLE_USER").toString())) {
            return "homePage.jsp";
	    }else {

            return "redirect:/admin";
    		}
	}
	
    @RequestMapping("/admin")
    public String adminPage(Principal principal, @ModelAttribute("getpackage") GetPackage getpackage, Model model) {
        String username = principal.getName();
        System.out.print("dfdf");
		User getuser = userService.findByUserName(username);
		System.out.println(getuser.getRoles().get(0).getName());
		if(getuser.getRoles().get(0).getName().equals("ROLE_ADMIN")) {

        model.addAttribute("currentUser", userService.findByUserName(username));
        model.addAttribute("allusers", userService.findallUsers());
        model.addAttribute("allpackages", packageService.findallPackages());
        model.addAttribute("roleadmin", userService.findRoleByName("ROLE_ADMIN"));
        model.addAttribute("roleuser", userService.findRoleByName("ROLE_USER"));
        return "adminPage.jsp";
		}
		else {
			return "redirect:/login";
		}
    }
    
    @PostMapping("/package/new")
    public String createPackage(Principal principal, @ModelAttribute("getpackage") GetPackage getpackage, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("ffdf error");
			System.out.println(result.getAllErrors());
			return "redirect:/admin";
		}else {
			String username = principal.getName();
			User getuser = userService.findByUserName(username);
			System.out.println(getpackage.getName());
			packageService.savePackage(getpackage);
			return "redirect:/admin";
		}
    }
    
    @RequestMapping(value="/deactivate/{packid}")
    public String deactivatedthis( @PathVariable("packid") Long packid) {
    		packageService.deactivate(packid);
    		return "redirect:/admin";
    }
    
    @RequestMapping(value="/activate/{packid}")
    public String activatedthis(@PathVariable("packid") Long packid) {  
    		packageService.activate(packid);
    		return "redirect:/admin";
    }

    @RequestMapping("/delete/{packid}")
    public String deleteEvent(@PathVariable("packid") Long id) {
    		packageService.delete(id);
    		return "redirect:/admin";
    }
    
    @PostMapping("/updateuser/{id}")
    public String editEvent(@PathVariable("id") Long personid, @Valid @ModelAttribute("getuser") User user, BindingResult result, @RequestParam("dueDay") int dueDay, @RequestParam("getpackage") GetPackage getpackage) {    		
    		if(result.hasErrors()) {
    			return "redirect:/";
    		}
    		else {
    			userService.updateUser(personid, dueDay, getpackage);
    			return "redirect:/profile";
    		}

    }

    @RequestMapping("/profile")
    public String profile(Principal principal, Model model, @Valid @ModelAttribute("getuser") User user, BindingResult result) {    		
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUserName(username));

    		return "person.jsp";
    }

}



