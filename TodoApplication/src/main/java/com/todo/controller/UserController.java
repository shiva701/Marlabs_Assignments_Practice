package com.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.UserDao;
import com.todo.model.User;

/**
 * Servlet implementation class UserController mapping defines by @WebServlet.
 */
@WebServlet("/register")
public class UserController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user dao dependency. */
	private UserDao userDao;

	/**
	 * Instantiates a new user controller.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		userDao = new UserDao();
	}

	/**
	 * Do get.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get request is not supported!!");
		response.sendRedirect("register/register.jsp");
	}

	/**
	 * Do post.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	/**
	 * Register.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Register servlet register method!!");
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String uname = request.getParameter("username");
		String password = request.getParameter("password");

		// create the user object to save to the database.
		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setUserName(uname);
		user.setPassword(password);

		// save the object to the database.
		try {
			int result = userDao.registerEmployee(user);
			if (result == 1) {
				request.setAttribute("Notification", "User Registered Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("register/register.jsp");
		rd.forward(request, response);
	}

}
