package com.tiru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiru.domain.Products;
import com.tiru.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {

	ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("product/{id}")
	@ResponseBody
	public Products getById(@PathVariable Long id) {
		return productService.getProduct(id);
	}

	/*
	 * same as above method, but is mapped to /products/product?id= rather than
	 * /products/product/{id}
	 */
	@RequestMapping(value = "product", params = "id")
	@ResponseBody
	public Products getByIdFromParam(@RequestParam("id") Long id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(value="product", method=RequestMethod.POST)
	@ResponseBody
	public String savePerson(Products  product) {
		System.out.println("Product Serivce  : Save");
		productService.processProducts(product);
		return "Saved person: " + product.toString();
	}
}
