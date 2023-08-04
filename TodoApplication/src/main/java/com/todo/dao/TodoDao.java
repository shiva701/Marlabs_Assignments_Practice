package com.todo.dao;

import java.sql.SQLException;
import java.util.List;

import com.todo.model.Todo;

/**
 * The Interface TodoDao.
 */
public interface TodoDao {
	
	/**
	 * Insert todo.
	 *
	 * @param todo the todo
	 * @throws SQLException the SQL exception
	 */
	void insertTodo(Todo todo) throws SQLException;

	/**
	 * Select todo.
	 *
	 * @param todoId the todo id
	 * @return the todo
	 */
	Todo selectTodo(long todoId);

	/**
	 * Select all todos.
	 *
	 * @return the list
	 */
	List<Todo> selectAllTodos();

	/**
	 * Delete todo.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	boolean deleteTodo(int id) throws SQLException;

	/**
	 * Update todo.
	 *
	 * @param todo the todo
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	boolean updateTodo(Todo todo) throws SQLException;
}
