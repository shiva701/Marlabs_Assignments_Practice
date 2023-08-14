package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class HelloController.
 */
@Controller
public class HelloController {
	
	/**
	 * My first action.
	 *
	 * @return the model and view
	 */
	@RequestMapping("helloFromMe")
	public ModelAndView myFirstAction() {
		String message = "Hello, All the best for spring 5 MVC!";
		System.out.println("Inside action!!");
		return new ModelAndView("hello", "mySimpleMessage", message); // view page name, data param key, data
	}
}