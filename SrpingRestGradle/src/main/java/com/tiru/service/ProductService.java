package com.tiru.service;

import java.util.List;

import com.tiru.domain.Products;

public interface ProductService {

	public List<Products> getProducts();
	public void processProducts(Products product);
	public Products getProduct(Long id);
}
