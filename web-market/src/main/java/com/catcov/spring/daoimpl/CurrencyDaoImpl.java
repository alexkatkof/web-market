package com.catcov.spring.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.catcov.spring.dao.CurrencyDao;
import com.catcov.spring.models.Currency;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {
	
	@Autowired
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 

	@Override
	public List<Currency> getPricesList(String currency, int size, int pageNumber) { 
		System.out.println("getPricesList");
		System.out.println("size is " + size);
		System.out.println("pageNumber is " + pageNumber);
		int begin = 0 + ((pageNumber - 1) *  size);
		System.out.println("begin is " + begin);
		int end =  size + ((pageNumber - 1) *  size);
		System.out.println("end is " + end);
		 
		return template.query("select " + currency + "  from prices " + " where id between  " + begin + " and " + end ,new RowMapper<Currency>(){  
			   public Currency mapRow(ResultSet rs, int row) throws SQLException {  
				   Currency e= new Currency(); 
			          e.setPrice(rs.getDouble(1));  
			          return e;  
			}       
		}); 
	}

}
