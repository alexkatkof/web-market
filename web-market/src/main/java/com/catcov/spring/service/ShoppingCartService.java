package com.catcov.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catcov.spring.models.Product;
import com.catcov.spring.models.ProductItem;

@Service
public class ShoppingCartService {
	
	@Autowired
	SessionService sessionService;

	public int exists(int id, List<ProductItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public Product find(int id) {
		List<Product> products = sessionService.getProduct("specialProduct");
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	
}
