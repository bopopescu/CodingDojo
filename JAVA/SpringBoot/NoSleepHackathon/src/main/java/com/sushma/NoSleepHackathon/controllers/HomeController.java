package com.sushma.NoSleepHackathon.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sushma.NoSleepHackathon.models.User;
import com.sushma.NoSleepHackathon.services.UserService;
import com.sushma.NoSleepHackathon.validator.UserValidator;


@Controller
public class HomeController {
	private UserService userService;
    private UserValidator userValidator;
	public HomeController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
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
			System.out.println("ffd");
			 String USAstates[] = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};

			model.addAttribute("USAstates", USAstates);
//			if(error != null) {
//				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
//			}
//			if(logout != null) {
//				model.addAttribute("logoutMessage", "Logout Successfull!");
//			}
			return "loginPage.jsp";
	}

	
	@RequestMapping(value= {"/", "/home"})
    public void newDojo() {
//		String yelpurl = "https://api.yelp.com/v3/businesses/search?location=San+Francisco&categories=bars,barcrawl,beergardens,karaoke,danceclubs&open_at=1504117800";
//	    try {
//	        URL obj = new URL(yelpurl);
//	        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//	        con.setRequestMethod("GET");
////	        con.setRequestProperty("grant_type", "client_credentials");
////	        con.setRequestProperty("client_id", "r-_7zVhQ1BNz2NX66dZa3w");
////	        con.setRequestProperty("client_secret", "hHfxcfRhUsM0tgTkrpd0BrzSgEhQYhLv4e2rmuWJBoJk2V23vwny3ZsBSHY4TXAt");
//	        con.setRequestProperty("Authorization", "Bearer qq0JulSsuz-_a1if702IvBLw2lCCSWTDUUh166mAGrBnyDk4F-QfplrwOGpAXHpnJdKkk776cyc6oRGqbIZyGySnO9USLOLqpxx1Eq-YxXZWfrv_nt69MLM2-BKlWXYx");
//	        con.setDoOutput(true);
//	        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//	        StringBuffer buffer = new StringBuffer();
//
//	        String inputLine = reader.readLine();
//	        buffer.append(inputLine);
//	        System.out.println(buffer.toString());
//			//model.addAttribute("getJson", buffer.toString());
//	        int responseCode = con.getResponseCode();
//	        System.out.println(con.getURL());
//	        JSONObject gt = new JSONObject(buffer.toString());
//	        Date now = new Date();      
//	        Long longTime = new Long(now.getTime()/1000);
//	        System.out.println(longTime.intValue());
//
////	        JSONParser parser = new JSONParser();
////	        JSONObject response = null;
////	        response = (JSONObject) parser.parse(buffer.toString());
//
//	        JSONArray businessesArray = (JSONArray) gt.get("businesses");
//	        for (int i = 0; i < businessesArray.length(); i++) {
//	            JSONObject businessObject = businessesArray.getJSONObject(i);
//	            System.out.println(businessObject.get("name").toString());
////	            if (businessObject.get("name").toString().contains("Delfina")) {
////	                //Do something with this object
////	                System.out.println(businessObject);
////	            }
//	        }
//
//	        System.out.println("Response Code: " + responseCode);   
//	    } catch (Exception e) {
//	        // TODO Auto-generated catch block
//	    		System.out.println("nooooo");
//	        e.printStackTrace();
//	    }

    }

}
