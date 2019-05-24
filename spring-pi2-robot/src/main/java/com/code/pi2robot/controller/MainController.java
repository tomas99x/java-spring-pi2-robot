package com.code.pi2robot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/")
	public String greeting() {
		
		ModelAndView mavIndex = new ModelAndView("index"); 
		
		return "index";
	}
	
}
