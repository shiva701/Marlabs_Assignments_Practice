package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.todo.model.User;
import com.todo.utils.JDBCUtils;

/**
 * The Class UserDao.
 */
public class UserDao {
	
	/** The insert SQL. */
	String insertSQL = "insert into users" + " (first_name, last_name, username, password) " + "values " + "(?,?,?,?)";
	
	/** The result. */
	int result = 0;

	/**
	 * Register employee.
	 *
	 * @param user the user
	 * @return the int
	 */
	public int registerEmployee(User user) {
		try (Connection conn = JDBCUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(insertSQL)) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return result;
	}
}
