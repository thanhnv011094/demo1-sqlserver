package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Column(name = "id", nullable = false, unique = true)
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

	@Column(name = "tax", nullable = true)
	private float tax;

	@ManyToOne
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Order() {
		super();
	}

	public Order(float tax, Promotion promotion) {
		super();
		this.tax = tax;
		this.promotion = promotion;
	}

}
