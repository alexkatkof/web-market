package com.catcov.spring.models;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Order {
	
    Date date = new Date();
	Locale Locale;
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale);
	private String formattedDate = dateFormat.format(date);
	private ProductItem productItem;
	
	public ProductItem getProductItem() {
		return productItem;
	}
	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	
	public Order() {}
	public Order(ProductItem productItem, String formattedDate) {
		this.productItem = productItem;
		this.formattedDate = formattedDate;
	}

}
