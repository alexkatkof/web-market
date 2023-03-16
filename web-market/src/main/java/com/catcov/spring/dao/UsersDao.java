package com.catcov.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsersDao {
	
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	
	public int checkUser(String login, String password) {
		int amount = template.queryForObject(
			    "select count(*) from users where login='" + login + "' and password='" + password + "'", Integer.class);
		return amount;
	}


}
