package com.sushma.learningplatform.controllers;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeControllers {
    @RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
    public String showAssignment(Model model, @PathVariable("chapter") Integer chapter, @PathVariable("assignmentNumber") String assignmentNumber){
    		System.out.println(chapter.getClass().getName());
    		System.out.println(assignmentNumber);
    		String say = "wewe";
    		if(chapter == 38) {
    			System.out.println("fdfd");
			if(assignmentNumber.equals("0345")) {
				say = "Coding Form";
			}
    		}
    		else if(chapter == 26) {
			if(assignmentNumber.equals("2342")) {
				say = "Fortran to Binary";
			}
    		}
    		model.addAttribute("content", say);
    		return "assignment";
    			
		   
    }

    @RequestMapping("/m/{chapter}/0553/{lessonNumber}")
    public String showLesson(Model model, @PathVariable("chapter") String chapter,  @PathVariable("lessonNumber") String lessonNumber){
    		System.out.println(chapter.getClass().getName());
    		System.out.println(lessonNumber);
    		if(chapter.equals("38")) {
    				if(lessonNumber.equals("0733")) {
    					model.addAttribute("content", "Setting up your servers");
    				}
    				else if(lessonNumber.equals("0342")) {
    					model.addAttribute("content", "Punch Cards");
    				}
    		}
    		else if(chapter.equals("26")) {
			if(lessonNumber.equals("0348")) {
				model.addAttribute("content", "Advanced Fortran Intro");
			}

    		}
    		return "lesson";
    			
		   
    }
    
}
