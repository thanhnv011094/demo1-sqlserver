package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

	@Column(name = "id", nullable = false, unique = true)
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	
	@Column(name = "thumbnail", nullable = true)
    private String thumbnail;
	
	@Column(name = "name", nullable = true)
    private String name;

	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "price", nullable = true)
	private double price;
	
	@Column(name = "ref", nullable = true)
	private String ref;

	 
	public Product() {
    }
    
    public Product(String thumbnail, String name, String description, double price, String ref) {
    	this.thumbnail = thumbnail;
    	this.name = name;
    	this.description = description;
    	this.price=price;
    	this.ref = ref;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
    
    
}