package com.catcov.spring.dao;

import java.sql.Blob;
import java.util.List;

import com.catcov.spring.models.Product;

public interface ProductDao {
	
	public Blob getPhotoById(int id);
	
	public List<Product> findProductByIdOrName(String txt, String currency);
	
	public List<Product> findProductByIdOrName(int txt, String currency);
	
	public List<Product> getProductInfo(int id);
	
	public int getAmountProducts();
	
	public List<Product> getProductsList(int size, int pageNumber);
	
	public List<Product> getProductsListNew(int size, int pageNumber, String currency);
	
	public List<Product> getProducts();
	
	
	public List<Product> getItem(String id, String currency);
	
	public int saveProduct(Product product);
	
	public int updateProduct(Product product);
	
	public int deleteProduct(Product product);
	
	
	

}
