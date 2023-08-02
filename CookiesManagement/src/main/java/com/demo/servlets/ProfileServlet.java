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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		out.println("<br><br>"
				+ "<hr>");
		
		
		Cookie ck[] = request.getCookies();
		
		if(ck != null) { 
			String name = ck[0].getValue();
			if(!name.equals("") || name != null) {
				out.println("<h3> Succesfully Logged in using Cookies !!! " +name);
			}
		}else { 
			out.println("<b> Login first ..... </b>"); 
			request.getRequestDispatcher("link.html").include(request, response);
			
		}
		
	}

}
