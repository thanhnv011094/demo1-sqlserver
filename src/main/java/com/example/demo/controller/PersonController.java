package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.PersonService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
	
	@Autowired
    private PersonService personService;

    @GetMapping("/")
    // method that returns all items
    public ResponseEntity<List<Person>> getAll() {
    	return ResponseEntity.ok(personService.findAll());
    }
    
    @GetMapping("/{id}")
    // method that returns a specific item
    public ResponseEntity<Person> getPerson(@PathVariable(value = "id") long id) {
    	Optional<Person> personOptional = personService.findById(id);
        return personOptional.map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/")
    // method that creates a new item
    public ResponseEntity<Person> save(@RequestBody Person newPerson) {
    	try {
    		Person person =
    				personService.save(new Person(newPerson.getFirstName(), newPerson.getLastName(), newPerson.getAge()));
    	      return new ResponseEntity<>(person, HttpStatus.CREATED);
    	} catch (Exception e) {
    	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
         
    @PutMapping("/{id}")
    // method that updates an item
    public ResponseEntity<Person> update(@RequestBody Person updatedPerson, @PathVariable(value = "id") long id) {
    	Optional<Person> personOptional = personService.findById(id);

        return personOptional.map(person -> {
        	updatedPerson.setId(person.getId());
            return new ResponseEntity<>(personService.save(updatedPerson), HttpStatus.OK);
            
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
     
    @DeleteMapping("/{id}")
    // method that deletes an item
    public ResponseEntity<Person> delete(@PathVariable(value = "id") long id) {
    	Optional<Person> personOptional = personService.findById(id);
    	
        return personOptional.map(person -> {
        	personService.remove(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
            
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
