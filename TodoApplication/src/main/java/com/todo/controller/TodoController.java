package com.todo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TodoDao;
import com.todo.dao.TodoDaoImpl;
import com.todo.model.Todo;
import com.todo.utils.JDBCUtils;

/**
 * Servlet implementation class TodoController.
 */
@WebServlet("/")
public class TodoController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The todo dao. */
	private TodoDao todoDao;

	/**
	 * Instantiates a new todo controller.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoController() {
		super();
		todoDao = new TodoDaoImpl();
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
		System.out.println("**** Inside TodoController get method ****");
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertTodo(request, response);
				break;
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateTodo(request, response);
				break;
			case "/list":
				listTodo(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
	}

	/**
	 * List todo.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	private void listTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Todo> listTodo = todoDao.selectAllTodos();
		request.setAttribute("listTodo", listTodo);
		RequestDispatcher rd = request.getRequestDispatcher("todo/todo-list.jsp");
		rd.forward(request, response);
	}

	/**
	 * Update todo.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException
	 * @throws SQLException
	 */
	private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Long id = Long.parseLong(request.getParameter("id"));

		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String description = request.getParameter("description");
		// DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));

		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		Todo updateTodo = new Todo(id, title, username, description, targetDate, isDone);

		todoDao.updateTodo(updateTodo);

		response.sendRedirect("list");

	}

	/**
	 * Show edit form.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Todo existingTodo = todoDao.selectTodo(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
		request.setAttribute("todo", existingTodo);
		dispatcher.forward(request, response);
	}

	/**
	 * Delete todo.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		todoDao.deleteTodo(id);
		response.sendRedirect("list");
	}

	/**
	 * Insert todo.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String description = request.getParameter("description");

		/*
		 * DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd"); LocalDate
		 * targetDate = LocalDate.parse(request.getParameter("targetDate"),df);
		 */

		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		Todo newTodo = new Todo(title, username, description, LocalDate.now(), isDone);
		todoDao.insertTodo(newTodo);
		response.sendRedirect("list");

	}

	/**
	 * Show new form.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Do post.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
