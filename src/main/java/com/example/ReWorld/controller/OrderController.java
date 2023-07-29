package com.example.ReWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ReWorld.models.OrderDTO;
import com.example.ReWorld.security.config.UserPrinciple;
import com.example.ReWorld.services.IAnimalService;
import com.example.ReWorld.services.IOrderService;
import com.example.ReWorld.services.IOrderStatusService;
import com.example.ReWorld.services.IServicePackageService;

@Controller
public class OrderController {
	@Autowired
	private IAnimalService animalService;
	
	@Autowired
	private IServicePackageService packageService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderStatusService orderStatusService; 
	
	@GetMapping(value = { "/order-logs" })
	private String orderLogs(Model model) {
		UserPrinciple user = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("logs",orderStatusService.history(user.getId()));
		model.addAttribute("route", "/order-logs");
		return "changelogs";
	}

	@GetMapping(value = { "/contact" })
	private String contact(Model model) {
		model.addAttribute("animals", animalService.findAll());
		model.addAttribute("services",packageService.findAll());
		model.addAttribute("route", "/contact");
		return "contact";
	}

	@PostMapping("/order")
	private String orderService(Model model, @ModelAttribute OrderDTO order) {
		UserPrinciple user = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		orderService.createOrder(order,user.getId());
		model.addAttribute("route", "/order-logs");
		return "redirect:/order-logs";
	}
}
