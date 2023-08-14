package com.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.dao.LoginFormDAO;
import com.demo.model.LoginForm;

/**
 * The Class UserController.
 */
@Controller
public class UserController {
	
	/** The login form DAO. */
	@Autowired
	private LoginFormDAO loginFormDAO;

	/**
	 * Load user login form.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET, path = "userLogin")
	public String loadUserLoginForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "login"; // view page name
	}

	/**
	 * Process login form.
	 *
	 * @param model the model
	 * @param loginForm the login form
	 * @param result the result
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.POST, path = "userLogin")
	public String processLoginForm(Map model,@Valid LoginForm loginForm, BindingResult result) {
		String uName = loginForm.getUsername();
		String pass = loginForm.getPassword();
		
		//result from hibernate validations
		if(result.hasErrors()) {
			return "login";
		}
		
		LoginForm orig = loginFormDAO.getUser(uName);
		if(orig!=null) {
			if (uName.equals(orig.getUsername()) && pass.equals(orig.getPassword())) {
				model.put("welcomeMessage", "Hi! Login is successful!");
				return "welcome";
			}
		}
		model.put("errorMessage", "Oh! Invalid login credentials...");
		return "error";
	}
}
