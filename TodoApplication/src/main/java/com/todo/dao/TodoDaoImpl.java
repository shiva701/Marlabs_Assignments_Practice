package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
		Todo todo = null;
		try (Connection conn = JDBCUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_TODO_BY_ID)) {
			ps.setLong(1, todoId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("is_done");
				todo = new Todo(id, title, username, description, targetDate, isDone);
			}
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return todo;
	}

	/**
	 * Select all todos.
	 *
	 * @return the list
	 */
	@Override
	public List<Todo> selectAllTodos() {
		List<Todo> todoList = new ArrayList<>();
		try (Connection conn = JDBCUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_ALL_TODOS)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				todoList.add(new Todo(rs.getLong("id"), rs.getString("title"), rs.getString("username"),
						rs.getString("description"), rs.getDate("target_date").toLocalDate(),
						rs.getBoolean("is_done")));
			}
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return todoList;
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
		boolean rowDeleted = false;
		try (Connection conn = JDBCUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(DELETE_TODO_BY_ID)) {
			ps.setLong(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return rowDeleted;
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
		boolean isUpdated = false;
		try (Connection conn = JDBCUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_TODO)) {
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getUsername());
			ps.setString(3, todo.getDescription());
			ps.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
			ps.setBoolean(5, todo.isStatus());
			ps.setLong(6, todo.getId());
			isUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return isUpdated;
	}

}
