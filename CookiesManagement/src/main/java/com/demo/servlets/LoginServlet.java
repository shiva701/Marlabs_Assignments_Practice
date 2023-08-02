package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		out.println("<br><br>"
				+ "<hr>");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(name.equals(pass)) {
			out.println("<h2> Login Successful Welcome  user ::: " +name + "</h2>");
			Cookie ck = new Cookie("name", name);
			response.addCookie(ck);
			System.out.println(name);
			
		}else { 
			out.println("<b><color = red> Sorry user name and password is incorrect </b>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		
	}

}
