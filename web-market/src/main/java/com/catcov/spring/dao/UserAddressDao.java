package com.catcov.spring.dao;

import java.util.List;

import com.catcov.spring.models.User;
import com.catcov.spring.models.UserAddress;

public interface UserAddressDao {
	
	public List<UserAddress> getUserAddress(String email);
	
	public int updateUserAddress(String country, String city, String street, String zipCode, String email);
	
	public int deleteUserAddress(User user);
	
	public int saveUserAdress(String country, String city, String street, String zipCode, String userEmail);

}
