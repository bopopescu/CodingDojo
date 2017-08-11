package com.sushma.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllers {
    @RequestMapping("/")
    public String index() {
            return "index.jsp";
    }

    @RequestMapping("/date")
    public String date(Model model) {
    			Date getdate = new Date();
    			SimpleDateFormat formatDate = new SimpleDateFormat("EEEEE, 'the' d 'of'  MMMMM, yyyy");
    			String formattedDate = formatDate.format(getdate).toString();
    			model.addAttribute("getdate", formattedDate);
            return "dateView.jsp";
    }

    @RequestMapping("/time")
    public String time(Model model) {
    			SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");
    			String formattedDate = formatDate.format(new Date()).toString();
    			model.addAttribute("gettime", formattedDate);
            return "timeView.jsp";
    }

}
