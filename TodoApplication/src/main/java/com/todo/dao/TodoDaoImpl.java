package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.todo.model.Todo;
import com.todo.utils.JDBCUtils;

/**
 * The Class TodoDaoImpl.
 */
public class TodoDaoImpl implements TodoDao {

	private static final String INSERT_TODOS_SQL = "INSERT INTO todos"
			+ "  (title, username, description, target_date,  is_done) VALUES " + " (?, ?, ?, ?, ?);";

	private static final String SELECT_TODO_BY_ID = "select id,title,username,description,target_date,is_done from todos where id =?";
	private static final String SELECT_ALL_TODOS = "select * from todos";
	private static final String DELETE_TODO_BY_ID = "delete from todos where id = ?;";
	private static final String UPDATE_TODO = "update todos set title = ?, username= ?, description =?, target_date =?, is_done = ? where id = ?;";

	/**
	 * Insert todo.
	 *
	 * @param todo the todo
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void insertTodo(Todo todo) throws SQLException {
		System.out.println("Inserting the record: " + todo.toString());
		try (Connection conn = JDBCUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_TODOS_SQL)) {
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getUsername());
			ps.setString(3, todo.getDescription());
			ps.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
			ps.setBoolean(5, todo.isStatus());
			ps.executeUpdate();

		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
	}

	/**
	 * Select todo.
	 *
	 * @param todoId the todo id
	 * @return the todo
	 */
	@Override
	public Todo selectTodo(long todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Select all todos.
	 *
	 * @return the list
	 */
	@Override
	public List<Todo> selectAllTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Delete todo.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	@Override
	public boolean deleteTodo(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Update todo.
	 *
	 * @param todo the todo
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	@Override
	public boolean updateTodo(Todo todo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
