package com.catcov.spring.models;

import jakarta.validation.constraints.NotBlank;

public class UserAddress {
	
	@NotBlank(message = "Please write your country!")
	private String country;
	
	@NotBlank(message = "Please write your city!")
	private String city;
	
	@NotBlank(message = "Please write your street!")
	private String street;
	
	@NotBlank(message = "Please write your zi code!")
	private String zipCode;
	
	public UserAddress() {
	}
	
	public UserAddress(String country, String city, String street, String zipCode) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
}
