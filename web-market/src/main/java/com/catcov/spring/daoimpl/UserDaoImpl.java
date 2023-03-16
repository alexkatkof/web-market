package com.catcov.spring.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.catcov.spring.dao.RepositoryDao;
import com.catcov.spring.dao.UserDao;
import com.catcov.spring.models.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}

	@Override
	public int checkUser(String login, String password) {
		int amount = template.queryForObject(
			    "select count(*) from users where login='" + login + "' and password='" + password + "'", Integer.class);
		return amount;
	}

	@Override
	public List<User> getUserInfo(String email) {
		return template.query("select firstName, lastName, email from users where users.email='"+email+"';", new RowMapper<User>(){
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User e = new User();
				e.setFirstName(rs.getString(1));
				e.setLastName(rs.getString(2));
				e.setEmail(rs.getString(3));
				return e;
			}
		});
	}

	@Override
	public String getUserEmail(String login) {
		String sql = "select email from users where users.login= ?";
		return template.queryForObject(sql, new Object[]{login}, String.class);
		}

	@Override
	public int saveUser(String login, String pass, String email, String firstName, String lastName) {
		String query = "insert into users (login, password, email, firstName, lastName) values ('" + login + "', '" + pass + "', '" + email + "', '" + firstName + "', '" + lastName + "');";
		return template.update(query);
	}

	@Override
	public int updateUser(String firstName, String lastName, String email) {
		String sql = "update users set firstName = '" + firstName + "', lastName = '" + lastName + "' where email = '" + email + "'";
		return template.update(sql);
	}

	@Override
	public int deleteUser(User user) {
		String sql = "delete from user where email = '" + user.getEmail() + "'";
		return template.update(sql);
	}




	
	
}
