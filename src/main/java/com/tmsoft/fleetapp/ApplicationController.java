package com.tmsoft.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/index")
	public String goHome() {
		return "index";
	}
	
//	@GetMapping("/login")
//	public String login() {
//		return "pages-login";
//	}
//	
//	@GetMapping("/logout")
//	public String logout() {
//		return "pages-login";
//	}
}
