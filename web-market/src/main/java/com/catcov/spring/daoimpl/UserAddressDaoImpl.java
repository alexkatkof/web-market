package com.catcov.spring.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.catcov.spring.dao.UserAddressDao;
import com.catcov.spring.models.User;
import com.catcov.spring.models.UserAddress;

@Repository
public class UserAddressDaoImpl implements UserAddressDao{
	
	@Autowired
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}

	@Override
	public List<UserAddress> getUserAddress(String email) {
		return template.query("select country, city, street, zipCode from useradress where useradress.userEmail='"+email+"';", new RowMapper<UserAddress>(){
		public UserAddress mapRow(ResultSet rs, int row) throws SQLException {
			UserAddress e = new UserAddress();
			e.setCountry(rs.getString(1));
			e.setCity(rs.getString(2));
			e.setStreet(rs.getString(3));
			e.setZipCode(rs.getString(4));
			return e;
		}
	});
}

	@Override
	public int updateUserAddress(String country, String city, String street, String zipCode, String email) {
		String sql = "update useradress set country = '" + country + "', city = '" + city + "', street = '" + street + "', zipCode = '" +  zipCode + "' where userEmail = '" + email + "'";
		return template.update(sql);
	}

	@Override
	public int deleteUserAddress(User user) {
		String sql = "delete from useradress where userEmail = '" + user.getEmail() + "'";
		return template.update(sql);
	}

	@Override
	public int saveUserAdress(String country, String city, String street, String zipCode, String userEmail) {
		String query = "insert into useradress (country, city, street, zipCode, userEmail) values ('" + country + "', '" + city + "', '" + street + "', '" + zipCode + "', '" + userEmail + "');";
		return template.update(query);
	} 

}
