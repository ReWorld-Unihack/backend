package com.example.ReWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ReWorld.services.IServicePackageService;

@Controller
public class HomeController {
	@Autowired
	private IServicePackageService packageService;
	
	@GetMapping( value = {"/","/home"})
	private String  homepage(Model model){
		model.addAttribute("services",packageService.findAll());
		model.addAttribute("route","/home");
		return "index";
	}

	@GetMapping( value = {"/about"})
	private String  about(Model model){
		model.addAttribute("route","/about");
		return "about";
	}

}
