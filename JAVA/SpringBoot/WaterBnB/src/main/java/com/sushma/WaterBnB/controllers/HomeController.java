package com.sushma.WaterBnB.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


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

import com.sushma.WaterBnB.models.Pool;
import com.sushma.WaterBnB.models.Review;
import com.sushma.WaterBnB.models.User;
import com.sushma.WaterBnB.services.*;
import com.sushma.WaterBnB.validator.UserValidator;

@Controller
public class HomeController {
    private UserValidator userValidator;
    private UserService userService;
    private PoolService poolService;
    private ReviewService reviewService;
	public HomeController(UserValidator userValidator, UserService userService, PoolService poolService, ReviewService reviewService) {
		this.userValidator = userValidator;
		this.userService = userService;
		this.poolService = poolService;
		this.reviewService = reviewService;
	}
	

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("getuser") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			 String status[] = {"Host","Guest"};

			model.addAttribute("status", status);
			return "loginPage.jsp";
		}
		userService.saveUser(user);
		return "redirect:/guest/signin";
	}
	@RequestMapping("/guest/signin")
	public String login(@Valid @ModelAttribute("getuser") User user, BindingResult result, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
			 String status[] = {"Host","Guest"};
			model.addAttribute("status", status);
			System.out.println("hi");
			if(error != null) {
				System.out.println("what");
				System.out.println(result.getAllErrors());
				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
			}
			if(logout != null) {
				model.addAttribute("logoutMessage", "Logout Successfull!");
			}
			return "loginPage.jsp";
	}
	
	@RequestMapping("/search")
	public String searchPage(Principal principal, Model model, @RequestParam(value="location", required=false) String location) {
		if(principal != null) {
			String username = principal.getName();
			User getuser = userService.findByUserName(username);
			model.addAttribute("getuser", getuser);
		}
		else {
			User getuser = null;
			model.addAttribute("getuser", getuser);
		}
		
		if(location != null) {
			model.addAttribute("allpool", poolService.findlocationforPool(location));
		}
		else {
			model.addAttribute("allpool", poolService.findAll());
		}
		return "searchPage.jsp";

	}


	@RequestMapping(value= {"/", "/home"})
	public String home(Principal principal, Model model, @RequestParam(value="logout", required=false) String logout) {
		String username = principal.getName();
		Date now = new Date();
		System.out.println("sdsd");
		model.addAttribute("date", now);

		model.addAttribute("currentUser", userService.findByUserName(username));
		User thatuser = userService.findByUserName(username);
		if(thatuser.getStatus().equals("Host")) {
			System.out.println("Host");
			return "redirect:/host/dashboard";
		}
		else if(thatuser.getStatus().equals("Guest")) {
			
			System.out.println("Guest");
			return "redirect:/search";
		}
		else {
			return "homePage.jsp";
		}
//		return "searchPage.jsp";
        
	}
	
	@RequestMapping("/host/dashboard")
	public String dashbaord(Principal principal,Model model, @ModelAttribute("pool") Pool pool, @RequestParam(value="logout", required=false) String logout) {
		String username = principal.getName();
		User getuser = userService.findByUserName(username);
		if(getuser.getStatus().equals("Host")) {
			model.addAttribute("currentUser", userService.findByUserName(username));
			String pool_size[] = {"Small","Medium", "Large"};
			model.addAttribute("pool_size", pool_size);
			model.addAttribute("allHostpool", poolService.findHostPool(getuser.getId()));
			
			return "dashboardView.jsp";
		}
		else {
			return "redirect:/get";
		}
	}
    @PostMapping("/listing/new")
    public String createListing(Principal principal, @ModelAttribute("pool") Pool pool, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "newPool.jsp";
		}else {
			String username = principal.getName();
			User getuser = userService.findByUserName(username);
			if(getuser.getStatus().equals("Host")) {
				poolService.addPool(pool);
				return "redirect:/host/dashboard";
			}
			else {
				return "redirect:/get";
			}
			
		}
    }
	@RequestMapping("/get")
	public String first() {
		return "homePage.jsp";
	}
	
	@RequestMapping("/host/pools/{poolid}")
	public String editPoolView(Model model, Principal principal, @PathVariable("poolid") Long poolid, @ModelAttribute("pool") Pool pool, BindingResult result) {
		String username = principal.getName();
		User getuser = userService.findByUserName(username);
		if(getuser.getStatus().equals("Host")) {
			String pool_size[] = {"Small","Medium", "Large"};
			model.addAttribute("pool_size", pool_size);
			Pool getpool = poolService.findPool(poolid);
			model.addAttribute("getpool", getpool);
			return "editPool.jsp";
		}
		
		else {
			return "redirect:/get";
		}
	}

	@RequestMapping("/pools/{poolid}")
	public String seePoolView(Model model, Principal principal, @PathVariable("poolid") Long poolid, @ModelAttribute("pool") Pool pool, BindingResult result) {
		Pool getpool = poolService.findPool(poolid);
		model.addAttribute("getpool", getpool);
		List<Review> allreviewsforpool= reviewService.findReviewsPool(poolid);
		model.addAttribute("allreviews", allreviewsforpool);
		Float totalavgrating = reviewService.findTotalAvgRatingforPool(poolid);
		model.addAttribute("totalavgrating", totalavgrating);
		return "showPool.jsp";

	}
	
	@RequestMapping("/pools/{poolid}/review")
	public String reviewPool(Model model, Principal principal, @PathVariable("poolid") Long poolid, @ModelAttribute("pool") Pool pool, BindingResult result, @ModelAttribute("review") Review review) {
		String username = principal.getName();
		User getuser = userService.findByUserName(username);
		if(getuser.getStatus().equals("Guest")) {
			int rating[] = {1, 2, 3, 4, 5};
			model.addAttribute("rating", rating);
			Pool getpool = poolService.findPool(poolid);
			model.addAttribute("currentUserid", getuser);
			model.addAttribute("getpool", getpool);
			return "review.jsp";
		}		
		else if(getuser.getStatus().equals("Host")) {
			return "redirect:/host/dashboard";
		}

		else {
			return "redirect:/guest/signin";
		}

	}
	
    @PostMapping("/review/{poolid}")
    public String postMessage(Principal principal, @PathVariable("poolid") Long poolid, Model model, @ModelAttribute("getpool") Pool pool, BindingResult result, @ModelAttribute("review") Review review) {  
		if(result.hasErrors()) {
			System.out.println("popop");
			System.out.println(result.getAllErrors());
			return "redirect:/review/{poolid}";
		}else {
	    		String username = principal.getName();
	    		System.out.println(username);
	    		User thatuser = userService.findByUserName(username);
	    		model.addAttribute("currentUserid", thatuser.getId());
	    		System.out.println("jhjh"+poolid);
	    		Pool getpool = poolService.findPool(poolid);
	    		model.addAttribute("getpool", getpool.getId());
	    		System.out.println("popop3");
	    		System.out.println("opp"+getpool.getId());
	    		reviewService.addReview(review, getpool.getId());
			return "redirect:/";
		}
    }


}
