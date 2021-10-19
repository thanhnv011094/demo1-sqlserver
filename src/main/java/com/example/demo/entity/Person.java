package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
public class Person {

	@Column(name = "id", nullable = false, unique = true)
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	
	@Column(name = "first_name", nullable = true)
    private String firstName;
	
	@Column(name = "last_name", nullable = false)
    private String lastName;

	@Column(name = "age", nullable = true)
	private int age;

	 
	public Person() {
    }
    
    public Person(String firstName, String lastName, int age) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
		this.id = id;
	}
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
