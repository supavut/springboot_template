package com.bangmodteam.workshop.controller;

import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {
	

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String test(Locale locale,Model model) {
        model.addAttribute("thymeleaf", "Test thymeleaf");  
        return "login";  
	}
	
	
}
