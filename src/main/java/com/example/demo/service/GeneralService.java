package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GeneralService<T> implements IGeneralService<T> {
	
	@Autowired
    protected JpaRepository<T, Long> repository;

    @Override
    public List<T> findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(long id){
    	return repository.findById(id);
    }
	
	@Override
    public T save(T newEntity){
        return repository.saveAndFlush(newEntity);
    }

    @Override
    public void remove(long id){
        repository.deleteById(id);
    }
	
}
