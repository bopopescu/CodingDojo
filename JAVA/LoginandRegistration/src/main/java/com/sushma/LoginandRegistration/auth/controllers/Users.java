package com.sushma.LoginandRegistration.auth.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sushma.LoginandRegistration.auth.models.User;

@Controller
public class Users {
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "loginPage.jsp";
    }
    

}
