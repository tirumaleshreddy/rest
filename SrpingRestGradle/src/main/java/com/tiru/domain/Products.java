package com.tiru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRODUCTS", catalog = "test")
public class Products {

	long id;
	String description;
	float price;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(long id, String description, float price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", description=" + description
				+ ", price=" + price + "]";
	}

	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")  
    @GeneratedValue(generator = "mygen1")  
	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", unique = true, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRICE", unique = true, nullable = false)
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
