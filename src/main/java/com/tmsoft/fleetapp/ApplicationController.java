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
}
