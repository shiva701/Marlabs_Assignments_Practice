package com.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotEmpty(message="UN must not be left blank!")
	@Size(min=4, max=12, message="UN length is between 4 and 12")
	private String username;
	
	@NotEmpty(message="Password shouldn't be empty...")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
