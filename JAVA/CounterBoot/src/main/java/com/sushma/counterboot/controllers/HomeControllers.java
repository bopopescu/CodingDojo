package com.sushma.counterboot.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.*;
import java.util.*;

@Controller
@SessionAttributes("sessionAttribute")

public class HomeControllers {
//    @RequestMapping("/")
//    public String index() {
//            return "home.jsp";
//    }
//    
    @RequestMapping("/")
    public String index(HttpSession session) {
        Integer get = (Integer) session.getAttribute("count");
        if(get == null) {
        		session.setAttribute("count", 0);
        }
        else {
			//Integer clicks1 = (Integer) session.getAttribute("count");
			get++;
        		session.setAttribute("count", get);
        }
            return "home.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session) {
    			Integer get = (Integer) session.getAttribute("count");
    			session.setAttribute("count", get);
            return "counterView.jsp";
    }


}
