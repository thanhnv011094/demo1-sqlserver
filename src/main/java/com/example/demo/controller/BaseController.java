package com.example.demo.controller;

import com.example.demo.service.IGeneralService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T> {
	
	@Autowired
    private IGeneralService<T> service;

    // method that returns all items
	@GetMapping("")
    public ResponseEntity<List<T>> index() {
    	return ResponseEntity.ok(service.findAll());
    }

    // method that returns a specific item
	@GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable(value = "id") long id) {
    	Optional<T> optional = service.findById(id);
    	
        return optional.map(t -> new ResponseEntity<T>(t, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // method that creates a new item
    @PostMapping("")
    public ResponseEntity<T> save(@RequestBody T newObject) {
    	try {
    		T savedResult = service.save(newObject);
    		return new ResponseEntity<T>(savedResult, HttpStatus.CREATED);
    	} catch (Exception e) {
    	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    // method that updates an item
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T updatedObject, @PathVariable(value = "id") long id) {
    	Optional<T> optional = service.findById(id);
    	
        return optional.map(t -> {
            return new ResponseEntity<T>(service.update(updatedObject, id), HttpStatus.OK);
            
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // method that deletes an item
    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@PathVariable(value = "id") long id) {
    	Optional<T> optional = service.findById(id);
    	
        return optional.map(t -> {
        	service.remove(id);
            return new ResponseEntity<T>(t, HttpStatus.OK);
            
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}