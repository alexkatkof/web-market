package com.catcov.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catcov.spring.dao.RepositoryDao;
import com.catcov.spring.models.Page;

@Service
public class ProductService {
	
	@Autowired
	RepositoryDao repositoryDao;

	public List<Page> getPages(int size) {
		System.out.println("getPages");
		List<Page> pages = new ArrayList<>();
		int amountProducts = repositoryDao.getAmountProducts();// -> amount all product from database
		System.out.println(amountProducts);
		int countPages = amountProducts / size; // -> amount full pages
		int lastPage = countPages + 1;
		int rest = amountProducts % size;// -> rest products in last page
		for (int i = 1; i <= countPages; i++) {
			pages.add(new Page("/products?size=" + size + "&page=", "" + i));
		}
		if (rest != 0) {
			pages.add(new Page("/products?size=" + size + "&page=", "" + lastPage));
		}
		return pages;
	}
}
