package com.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.LoginDao;
import com.todo.model.LoginBean;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class LoginController.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The login dao. */
	private LoginDao loginDao;
       
    /**
     * Instantiates a new login controller.
     *
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login/login.jsp");
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("**** Redirecting request to register.jsp page ****");
		authenticate(request, response);
	}

	/**
	 * Authenticate.
	 *
	 * @param request the request
	 * @param response the response
	 */
	private void authenticate(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		LoginBean login = new LoginBean();
		login.setUsername(uname);
		login.setPassword(pwd);
		
		try {
			if(loginDao.validate(login)) {
				RequestDispatcher rd = request.getRequestDispatcher("todo/todo-list.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("**** User credentials not mactched ****");
//				HttpSession session = request.getSession();
				response.sendRedirect("login/login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
