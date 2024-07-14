package com.tmsoft.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/users")
	public String getUsers() {
		return "pages-user";
	}
}
