package com.example.ReWorld.security.services;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Integer id);

    void update(T t);
    
    T add(T t);
    
    void remove(Integer id);
}
