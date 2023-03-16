package com.catcov.spring.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
//import javax.validation.constrains.Size;

public class User {

	@NotBlank(message = "Login is a required field!")
	private String login;

	@NotBlank(message = "Password is a required field!")
	private String pass;

	@Email(message = "Email must follow formatter: ***@***")
	@NotBlank(message = "Email is a required field!")
	private String email;

	@NotBlank(message = "Please write your first name!")
	private String firstName;

	@NotBlank(message = "Please write your last name!")
	private String lastName;

	@Valid
	private UserAddress address;

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public User() {

	}

	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}