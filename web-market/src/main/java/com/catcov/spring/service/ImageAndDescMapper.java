package com.catcov.spring.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import com.catcov.spring.models.ImageAndDesc;

public class ImageAndDescMapper implements RowMapper<ImageAndDesc> {

	@Override
	public ImageAndDesc mapRow(ResultSet rs, int rowNum) throws SQLException {
		ImageAndDesc product = new ImageAndDesc();
		product.setId(rs.getInt(1));
		product.setDescription(rs.getString(2));
		//product.setImage((MultipartFile) rs.getObject(3));
		return product;
	}
}
