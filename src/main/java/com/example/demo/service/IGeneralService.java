package com.example.demo.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(long id);

    T save(T t);

    void remove(Long id);
}