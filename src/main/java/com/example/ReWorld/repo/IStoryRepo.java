package com.example.ReWorld.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.Story;

public interface IStoryRepo extends JpaRepository<Story, Integer>{
	List<Story> findTop4ByOrderByLiked();
}
