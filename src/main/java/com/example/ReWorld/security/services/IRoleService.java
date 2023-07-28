package com.example.ReWorld.security.services;


import com.example.ReWorld.entities.Role;


public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}