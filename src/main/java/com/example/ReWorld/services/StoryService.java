package com.example.ReWorld.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReWorld.entities.Story;
import com.example.ReWorld.models.StoryDTO;
import com.example.ReWorld.repo.IAnimalRepo;
import com.example.ReWorld.repo.IStoryRepo;
import com.example.ReWorld.security.repositories.IUserRepository;

@Service
public class StoryService implements IStoryService{
	@Autowired
	private IAnimalRepo animalRepo;
	
	@Autowired
	private IStoryRepo storyRepo;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<Story> findAll() {
		return storyRepo.findAll();
	}

	@Override
	public Story addStory(StoryDTO story,Integer userId) {
		Story newStory=new Story();
		newStory.setAnimal(animalRepo.findById(story.getAnimalId()).orElse(null));
		newStory.setContent(story.getContent());
		newStory.setDescription(story.getDescription());
		newStory.setTitle(story.getTitle());
		newStory.setLiked(1);
		newStory.setImage(story.getImage());
		newStory.setDate(LocalDate.now());
		newStory.setScope(story.getScope());
		newStory.setSpecies(story.getSpecies());
		newStory.setUser(userRepository.findById(userId).orElse(null));
		return storyRepo.save(newStory);
	}

	@Override
	public Story findById(Integer id) {
		return storyRepo.findById(id).orElse(null);
	}

	@Override
	public List<Story> recommend() {
		return storyRepo.findTop4ByOrderByLiked();
	}
}
