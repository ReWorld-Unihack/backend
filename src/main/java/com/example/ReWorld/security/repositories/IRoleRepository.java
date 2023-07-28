package com.example.ReWorld.security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
