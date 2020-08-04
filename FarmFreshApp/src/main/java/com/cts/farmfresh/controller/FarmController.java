package com.cts.farmfresh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FarmController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpSession session) {
		session.removeAttribute("user");
    	session.removeAttribute("cart");
		return "firstpage";		
	}
	
	//@RequestMapping("/signup")
	//public String signup() {
		//return "signup";
	//}
	
	@RequestMapping("/login")	
		public String login() {
			return "login";
		}
	@RequestMapping("/home")
	   public String back() {
		return "home";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	
	}
	
