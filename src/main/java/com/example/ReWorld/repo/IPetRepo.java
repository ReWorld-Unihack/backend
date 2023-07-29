package com.example.ReWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.Pet;

public interface IPetRepo extends JpaRepository<Pet, Integer>{

}
