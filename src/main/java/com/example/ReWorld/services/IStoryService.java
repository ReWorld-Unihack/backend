package com.example.ReWorld.services;

import java.util.List;

import com.example.ReWorld.entities.Story;
import com.example.ReWorld.models.StoryDTO;

public interface IStoryService {
	List<Story> findAll();
	Story addStory(StoryDTO story,Integer userId);
	Story findById(Integer id);
	List<Story> recommend();
}
