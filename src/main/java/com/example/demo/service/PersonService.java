package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.*;
import com.example.demo.entity.*;

@Service
public class PersonService implements IGeneralService<Person> {
	@Autowired
    private PersonRepository repository;

    @Override
    public List<Person> findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<Person> findById(long id){
    	return repository.findById(id);
    }
	
	@Override
    public Person save(Person person){
        return repository.saveAndFlush(person);
    }

    @Override
    public void remove(Long id){
        repository.deleteById(id);
    }
}
