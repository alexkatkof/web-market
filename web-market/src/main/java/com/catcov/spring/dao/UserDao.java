package com.catcov.spring.dao;

import java.util.List;

import com.catcov.spring.models.User;

public interface UserDao {

	public int checkUser(String login, String password);

	public List<User> getUserInfo(String email);

	public String getUserEmail(String login);

	public int saveUser(String login, String pass, String email, String firstName, String lastName);

	public int updateUser(String firstName, String lastName, String email);

	public int deleteUser(User user);

}
