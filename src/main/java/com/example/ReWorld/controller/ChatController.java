package com.example.ReWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
	@GetMapping( value = {"/chat-contact"})
	private String  contact(Model model){
		model.addAttribute("route","/chat-contact");
		return "chat";
	}
}
