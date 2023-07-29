package com.example.ReWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.Animal;

public interface IAnimalRepo extends JpaRepository<Animal, Integer>{

}
