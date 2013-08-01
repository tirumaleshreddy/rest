package com.tiru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiru.dao.ProductsDao;
import com.tiru.domain.Products;

@Service
public class ProductServiceImpl implements ProductService {

	ProductsDao dao = null;
	
	
	@Autowired
	public void setDao(ProductsDao dao) {
		this.dao = dao;
	}

	public List<Products> getProducts() {
		return dao.getAll();
	}

	public void processProducts(Products product) {
		dao.create(product);
	}


	@Override
	public Products getProduct(Long id) {
		if(dao == null)
			System.out.println("Dao is not initialized");
		return dao.getProduct(id);
	}

}
