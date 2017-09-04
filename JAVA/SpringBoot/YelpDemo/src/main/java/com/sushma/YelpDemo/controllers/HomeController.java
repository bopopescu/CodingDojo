package com.sushma.YelpDemo.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.digester.DocumentProperties.Charset;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.*;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

	@RequestMapping("/")
    public void newDojo() {
		String yelpurl = "https://api.yelp.com/v3/businesses/search?location=San+Francisco&categories=bars,barcrawl,beergardens,karaoke,danceclubs&open_at=1504117800";
	    try {
	        URL obj = new URL(yelpurl);
	        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	        con.setRequestMethod("GET");
//	        con.setRequestProperty("grant_type", "client_credentials");
//	        con.setRequestProperty("client_id", "r-_7zVhQ1BNz2NX66dZa3w");
//	        con.setRequestProperty("client_secret", "hHfxcfRhUsM0tgTkrpd0BrzSgEhQYhLv4e2rmuWJBoJk2V23vwny3ZsBSHY4TXAt");
	        con.setRequestProperty("Authorization", "Bearer qq0JulSsuz-_a1if702IvBLw2lCCSWTDUUh166mAGrBnyDk4F-QfplrwOGpAXHpnJdKkk776cyc6oRGqbIZyGySnO9USLOLqpxx1Eq-YxXZWfrv_nt69MLM2-BKlWXYx");
	        con.setDoOutput(true);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        StringBuffer buffer = new StringBuffer();

	        String inputLine = reader.readLine();
	        buffer.append(inputLine);
	        System.out.println(buffer.toString());
			//model.addAttribute("getJson", buffer.toString());
	        int responseCode = con.getResponseCode();
	        System.out.println(con.getURL());
	        JSONObject gt = new JSONObject(buffer.toString());
	        Date now = new Date();      
	        Long longTime = new Long(now.getTime()/1000);
	        System.out.println(longTime.intValue());

//	        JSONParser parser = new JSONParser();
//	        JSONObject response = null;
//	        response = (JSONObject) parser.parse(buffer.toString());

	        JSONArray businessesArray = (JSONArray) gt.get("businesses");
	        for (int i = 0; i < businessesArray.length(); i++) {
	            JSONObject businessObject = businessesArray.getJSONObject(i);
	            System.out.println(businessObject.get("name").toString());
//	            if (businessObject.get("name").toString().contains("Delfina")) {
//	                //Do something with this object
//	                System.out.println(businessObject);
//	            }
	        }

	        System.out.println("Response Code: " + responseCode);   
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	    		System.out.println("nooooo");
	        e.printStackTrace();
	    }

    }


}



