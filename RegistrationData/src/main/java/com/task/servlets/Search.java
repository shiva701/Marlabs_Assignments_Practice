package com.task.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String id = request.getParameter("empID");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "admin1234");
			PreparedStatement pst = conn.prepareStatement("select * from employee where empid=?");
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if (!rs.next()) {
				out.println("No data present, please try again!!");
			} else {
				do {
					out.println("<html><head><title>EmpDetails</title></head><body>");
					out.println("<center>");
					out.println("<h1 style='color:blue'>Employee Details</h1><br><hr><br>");
					out.println("<table border='1' width='50%'>" + "<tr><td>ID</td><td>Name</td><td>Salary</td></tr>"
							+ "<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>"
							+ rs.getString(3) + "</td></tr>" + "</table>");
					out.println("</center></body></html>");
				} while (rs.next());
			}
			out.println("<a href='index.html'>Home Page</a>");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			out.close();
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Exception occured when closing the connection object!!");
				e.printStackTrace();
			}
		}
	}

}
