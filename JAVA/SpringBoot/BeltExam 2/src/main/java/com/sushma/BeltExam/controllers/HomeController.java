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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sushma.BeltExam.services.CourseService;
import com.sushma.BeltExam.services.SemesterService;
import com.sushma.BeltExam.services.UserService;

import com.sushma.BeltExam.validator.UserValidator;
import com.sushma.BeltExam.models.Course;
import com.sushma.BeltExam.models.User;

@Controller
public class HomeController {
	private UserService userService;
	private CourseService courseService;
	private UserValidator userValidator;
	private SemesterService semesterService;
	public HomeController(UserValidator userValidator, UserService userService, CourseService courseService, SemesterService semesterService) {
		this.userValidator = userValidator;
		this.userService = userService;
		this.courseService = courseService;
		this.semesterService = semesterService;
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
		
		userService.saveUser(user);
		System.out.println(user.getCreatedAt());
		semesterService.saveSemester(user);
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
	public String home(Principal principal, Model model, @ModelAttribute("course") Course course) {
		String username = principal.getName();
//		Date now = new Date();
//		System.out.println("sdsd");
//		model.addAttribute("date", now);
//
		model.addAttribute("currentUser", userService.findByUserName(username));
		System.out.println(userService.findByUserName(username).getCreatedAt().getYear()+1900);
		System.out.println(userService.findByUserName(username).getCreatedAt().getMonth()+1);
//		User thatuser = userService.findByUserName(username);
//		System.out.println(thatuser.getState());
//		List<Event> findAllEventNearBy = eventService.findAllEventNearBy(thatuser.getState());
//		model.addAttribute("allEventsNearBy", findAllEventNearBy);
//		List<Event> allEvents = eventService.findAllEventsNotNearYou(thatuser.getState());
//		model.addAttribute("allEvents", allEvents);

        return "homePage.jsp";
	}
	
	@RequestMapping("/courses")
	public String courseView(Principal principal, Model model) {
		String username = principal.getName();
//		Date now = new Date();
//		System.out.println("sdsd");
//		model.addAttribute("date", now);
//
		model.addAttribute("currentUser", userService.findByUserName(username));
//		User thatuser = userService.findByUserName(username);
//		System.out.println(thatuser.getState());
//		List<Event> findAllEventNearBy = eventService.findAllEventNearBy(thatuser.getState());
//		model.addAttribute("allEventsNearBy", findAllEventNearBy);
//		List<Event> allEvents = eventService.findAllEventsNotNearYou(thatuser.getState());
//		model.addAttribute("allEvents", allEvents);
		model.addAttribute("allcourses", courseService.findallCourses());

        return "coursePage.jsp";
	}


}
