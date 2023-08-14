package com.demo.dao;

import com.demo.model.LoginForm;

/**
 * The Interface loginFormDAO.
 */
public interface LoginFormDAO {
	
	/**
	 * Gets the user.
	 *
	 * @param username the username
	 * @return the user
	 */
	public LoginForm getUser(String username);
}
