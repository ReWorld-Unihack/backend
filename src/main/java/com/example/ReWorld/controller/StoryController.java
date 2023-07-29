package com.example.ReWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ReWorld.models.StoryDTO;
import com.example.ReWorld.security.config.UserPrinciple;
import com.example.ReWorld.services.IAnimalService;
import com.example.ReWorld.services.IStoryService;

@Controller
public class StoryController {
	@Autowired
	private IStoryService storyService;
	
	@Autowired
	private IAnimalService animalService;
	
	@GetMapping(value = { "/story" })
	private String story(Model model) {
		model.addAttribute("animals",animalService.findAll());
		model.addAttribute("stories", storyService.findAll());
		model.addAttribute("likedStories",storyService.recommend());
		model.addAttribute("route", "/story");
		return "blog";
	}

	@GetMapping(value = { "/add-story" })
	private String formStory(Model model) {
		model.addAttribute("animals",animalService.findAll());
		model.addAttribute("route", "/story");
		return "add-blog";
	}

	@PostMapping(value = { "/story" })
	private String postStory(Model model, @ModelAttribute StoryDTO story) {
		UserPrinciple user = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		storyService.addStory(story,user.getId());
		return "redirect:/story";
	}
	
	@GetMapping("/story/{id}" )
	private String storyDetail(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("story", storyService.findById(id));
		model.addAttribute("route", "/story");
		return "blog-single";
	}
}
