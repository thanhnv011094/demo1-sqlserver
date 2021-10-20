package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Promotions")
public class Promotion {

	@Column(name = "id", nullable = false, unique = true)
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	
	@Column(name = "code", nullable = true)
    private String code;
	
	@Column(name = "discount", nullable = true)
    private float discount;
	
	@OneToMany(mappedBy = "promotion")
    private List<Order> orders;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

//	public List<Order> getOrders() {
//		return orders;
//	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Promotion(String code, float discount, List<Order> orders) {
		super();
		this.code = code;
		this.discount = discount;
		this.orders = orders;
	}

	public Promotion() {
		super();
		this.orders = new ArrayList<Order>();
	}
}
