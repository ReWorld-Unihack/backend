package com.example.ReWorld.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReWorld.entities.Role;
import com.example.ReWorld.security.repositories.IRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

//    @Override
//    public Role save(Role role) {
//        return roleRepository.save(role);
//    }

    @Override
    public void remove(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

	@Override
	public void update(Role t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role add(Role t) {
		// TODO Auto-generated method stub
		return null;
	}
}
