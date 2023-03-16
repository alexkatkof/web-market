package com.catcov.spring.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.catcov.spring.models.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt(1));  
		product.setTitle(rs.getString(2));
		product.setPrice(rs.getDouble(3));
		return product;
	}

}
