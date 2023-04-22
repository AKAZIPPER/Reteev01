package com.project.reteev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Index() {
		return "index";
	}

	@GetMapping("/home")
	public String Home() {
		return "home";
	}
}
