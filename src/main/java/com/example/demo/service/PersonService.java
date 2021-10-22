package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;

@Service
public class PersonService extends GeneralService<Person> {

	@Override
	public Person update(Person person, long id) {
		person.setId(id);
		return repository.saveAndFlush(person);

	}
}
