package com.catcov.spring.dao;

import java.util.List;

import com.catcov.spring.models.Currency;

public interface CurrencyDao {
	
	public List<Currency> getPricesList(String currency, int size, int pageNumber);

}
