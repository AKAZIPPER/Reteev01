package com.project.reteev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Index() {
		return "login";
	}

	@GetMapping("/introduce")
	public String introduce() {
		return "/views/reteev_introduce";
	}

	@GetMapping("/profile")
	public String profile() {
		return "/views/reteev_profile";
	}
}
