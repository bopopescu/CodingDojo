package com.sushma.DojoOverflow.controllers;

import java.util.*;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.sushma.DojoOverflow.models.*;
import com.sushma.DojoOverflow.services.*;

@Controller
public class DojoOverflowController {
	private final QuestionService questionService;
	private final TagService tagService;
	
	public DojoOverflowController(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
    @RequestMapping("/questions/new")
    public String newCategory(@ModelAttribute("question") QuestionsModel question, @ModelAttribute("tag") Tags tag) {
    		System.out.println("new question view");
        return "newQuestion.jsp";
    }
    
//    @PostMapping("/questions/new")
//    public String createPerson(@Valid @ModelAttribute("question") QuestionsModel question, @RequestParam("myTags") String myTags, BindingResult result) {
//    		if(result.hasErrors()) {
//    			return "newQuestion.jsp";
//    		}else {
//    			questionService.addQuestion(question);
//    			List<String> tagsList = Arrays.asList(myTags.split(","));
//    			for(int i = 0; i < tagsList.size(); i++) {
//    				questionService.addTagToQuestion(question.getId(), tagsList.get(i));
//    			}
//    			return "redirect:/questions/new";
//    		}
//    }
}


