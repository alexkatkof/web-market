package com.catcov.spring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catcov.spring.models.Product;

@Service
public class SessionService {
	
	@Autowired
	HttpSession session;
	
	public List<Product> getProduct(String prop) {
		List<Product> product = (List<Product>)session.getAttribute(prop);
		return product;
	}
	
	public void setProduct(String prop, List<Product> products){
		session.setAttribute(prop, products);
	}
	

	public String getUser(String name) {
		String user = (String) session.getAttribute(name);
		return user;
	}
	
	public void setUser(String name, String user) {
		session.setAttribute(name, user);
	}
	
	public void removeUser(String name) {
		session.removeAttribute(name);
	}
	
	public String getCurrency(String currency) {
		currency =  (String) session.getAttribute(currency);
		return currency;
	}
	
	public void setCurrency(String currency, Object object) {
		session.setAttribute(currency, object);
	}

}
