package com.sushma.boottemplating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
    			model.addAttribute("dojoName", "Cupertino");
            return "index.jsp";
    }


}
