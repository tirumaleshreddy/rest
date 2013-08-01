package com.tiru.dao;

import java.util.List;

import com.tiru.domain.Products;

public interface ProductsDao {

		public List<Products> getAll();
		public void create(Products product);
		public Products getProduct(Long id);
}
