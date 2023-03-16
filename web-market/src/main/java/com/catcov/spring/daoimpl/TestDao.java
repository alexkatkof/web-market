package com.catcov.spring.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDao {
	
	@Autowired
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    

	public int saveUser(String email, String password, String firstName, String lastName) {
		String query = "INSERT INTO sql_products.users (login, paroli, email) "
				+ "VALUES ('" + email + "', '" + password + "', '" + firstName + "', '" + lastName + "');";
		return template.update(query);
	}

    
	

}
