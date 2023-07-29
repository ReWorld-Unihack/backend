package com.example.ReWorld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReWorld.entities.Animal;
import com.example.ReWorld.repo.IAnimalRepo;

@Service
public class AnimalService implements IAnimalService{
	@Autowired
	private IAnimalRepo animalRepo;

	@Override
	public List<Animal> findAll() {
		return animalRepo.findAll();
	}
	
	
}
