package com.example.ReWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping( value = {"/","/home"})
	private String  homepage(Model model){
		model.addAttribute("route","/home");
		return "index";
	}
	@GetMapping( value = {"/contact"})
	private String  contact(Model model){
		model.addAttribute("route","/contact");
		return "contact";
	}
}
