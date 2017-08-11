package com.sushma.dojosurvey.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller("/")
@Controller()
public class HomeControllers {
    @RequestMapping("/")
    public String index() {
            return "getsurveyView";
    }

    @RequestMapping("/result")
    public String result(Model model, @RequestParam(value="name") String yourname, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {
//    			Date getdate = new Date();
//    			SimpleDateFormat formatDate = new SimpleDateFormat("EEEEE, 'the' d 'of'  MMMMM, yyyy");
//    			String formattedDate = formatDate.format(getdate).toString();
//    			model.addAttribute("getdate", formattedDate);
    				model.addAttribute("yourname", yourname);
    				model.addAttribute("location", location);
    				model.addAttribute("language", language);
    				model.addAttribute("comment", comment);
            return "resultView";
    }


}
