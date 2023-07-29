package com.example.ReWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.ServicePackage;

public interface IServicePackageRepo extends JpaRepository<ServicePackage, Integer>{

}
