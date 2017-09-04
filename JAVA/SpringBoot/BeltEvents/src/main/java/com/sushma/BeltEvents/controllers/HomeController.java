package com.sushma.BeltEvents.controllers;

import java.security.Principal;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.sushma.BeltEvents.models.*;
import com.sushma.BeltEvents.services.UserService;
import com.sushma.BeltEvents.services.EventService;
import com.sushma.BeltEvents.services.MessageService;
import com.sushma.BeltEvents.validator.UserValidator;

@Controller
public class HomeController {
	private UserService userService;
	private EventService eventService;
	private MessageService messageService;
    private UserValidator userValidator;
	public HomeController(UserService userService, EventService eventService, MessageService messageService, UserValidator userValidator) {
		this.userService = userService;
		this.eventService = eventService;
		this.userValidator = userValidator;
		this.messageService = messageService;
	}

	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("getuser") User user, BindingResult result, Model model) {
		 String USAstates[] = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};

		model.addAttribute("USAstates", USAstates);

		return "registrationPage.jsp";
	}
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("getuser") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			String USAstates[] = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
			model.addAttribute("USAstates", USAstates);
			return "loginPage.jsp";
		}
		userService.saveUser(user);
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("getuser") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {

			 String USAstates[] = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};

			model.addAttribute("USAstates", USAstates);
			if(error != null) {
				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
			}
			if(logout != null) {
				model.addAttribute("logoutMessage", "Logout Successfull!");
			}
			return "loginPage.jsp";
	}
	
    @PostMapping("/event/new")
    public String createEvent(Principal principal, @ModelAttribute("event") Event event, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "newEvent.jsp";
		}else {
			String username = principal.getName();
			User getuser = userService.findByUserName(username);
			
			eventService.addEvent(event);
			return "redirect:/";
		}
    }

	@RequestMapping(value= {"/", "/home"})
	public String home(Principal principal, Model model, @ModelAttribute("event") Event event) {
		String username = principal.getName();
		Date now = new Date();
		System.out.println("sdsd");
		model.addAttribute("date", now);
		 String USAstates[] = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};

		model.addAttribute("USAstates", USAstates);

		model.addAttribute("currentUser", userService.findByUserName(username));
		User thatuser = userService.findByUserName(username);
		System.out.println(thatuser.getState());
		List<Event> findAllEventNearBy = eventService.findAllEventNearBy(thatuser.getState());
		model.addAttribute("allEventsNearBy", findAllEventNearBy);
		List<Event> allEvents = eventService.findAllEventsNotNearYou(thatuser.getState());
		model.addAttribute("allEvents", allEvents);

        return "homePage.jsp";
	}
	
    @RequestMapping("/events/{id}/edit")
    public String editEventView(Principal principal, @PathVariable("id") Long eventid, Model model) {
    		String username = principal.getName();
    		User thatuser = userService.findByUserName(username);
    		
    		Event getevent  = eventService.findEvent(eventid);
    		if(thatuser.getId() == getevent.getUser().getId()) {
    	   		 String USAstates[] = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};

    	  		model.addAttribute("USAstates", USAstates);

    	     		model.addAttribute("event", getevent);
    	     		return "editEvent.jsp";
    		}
    		else {
    			return "redirect:/";
    		}
    }
    
    @RequestMapping("/events/{id}")
    public String showEvent(Principal principal, @PathVariable("id") Long eventid, Model model, @Valid @ModelAttribute("message") Message message) {
    		Event getevent  = eventService.findEvent(eventid);
    		String username = principal.getName();
    		System.out.println(username);
    		User thatuser = userService.findByUserName(username);
    		model.addAttribute("currentUser", thatuser);
    		model.addAttribute("event", getevent);
    		List<Message> allmessages = messageService.getAllMessageforEvent(eventid);
    		model.addAttribute("allmessages", allmessages);
    		model.addAttribute("currentUserid", thatuser.getId());
    		model.addAttribute("attendees", getevent.getUsersattending());
    		return "showEvent.jsp";
    }
    
    @PostMapping("/message/{eventid}")
    public String postMessage(Principal principal, Model model, @PathVariable("eventid") Long eventid, @Valid @ModelAttribute("message") Message message, BindingResult result) {  
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "message.jsp";
		}else {
			System.out.println(eventid);
	    		String username = principal.getName();
	    		System.out.println(username);
	    		User thatuser = userService.findByUserName(username);
	    		model.addAttribute("currentUserid", thatuser.getId());
	    		
			messageService.addMessage(message, eventid, thatuser.getId());
			return "redirect:/";
		}
    }
    @PostMapping("/events/{id}/edit")
    public String editEvent(@PathVariable("id") Long eventid, @Valid @ModelAttribute("event") Event event, BindingResult result) {    		
    		if(result.hasErrors()) {
    			return "editEvent.jsp";
    		}
    		else {
    			eventService.updateEvent(eventid, event);
    			return "redirect:/";
    		}

    }
    
    @RequestMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
    		messageService.delete(id);
    		return "redirect:/";
    }
    
    
    @PostMapping("/join")
    public String joinEvent(@RequestParam("eventid") Long eventid, @RequestParam("userid") Long userid, @Valid @ModelAttribute("event") Event event, BindingResult result) {    		
    			eventService.addUserToEvent(eventid, userid);
    			return "redirect:/";

    }

    @PostMapping("/cancel")
    public String unjoinEvent(@RequestParam("eventid") Long eventid, @RequestParam("userid") Long userid, @Valid @ModelAttribute("event") Event event, BindingResult result) {    		
    			eventService.removeUserFromEvent(eventid, userid);
    			return "redirect:/";

    }


}
