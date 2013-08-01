package com.tiru.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products {
	long id;
	String description;
	float price;

	public long getId() {
		return id;
	}

	public Products(long id, String description, float price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
