package com.project.reteev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

	@GetMapping("/createUser")
	public String createUser() {
		
		return "/views/login/createUser";
	}
}
