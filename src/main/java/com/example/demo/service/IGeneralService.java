package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(long id);
    
    T save(T t);

    T update(T t, long id);

    void remove(long id);
}