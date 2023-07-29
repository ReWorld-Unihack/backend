package com.example.ReWorld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReWorld.entities.ServicePackage;
import com.example.ReWorld.repo.IServicePackageRepo;

@Service
public class ServicePackageService implements IServicePackageService{
	@Autowired
	private IServicePackageRepo servicePackageRepo;
	@Override
	public List<ServicePackage> findAll() {

		return servicePackageRepo.findAll();
	}

}
