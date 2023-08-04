package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todo.model.LoginBean;
import com.todo.utils.JDBCUtils;

/**
 * The Class LoginDao.
 */
public class LoginDao {

	/**
	 * Validate.
	 *
	 * @param loginBean the login bean
	 * @return true, if successful
	 */
	public boolean validate(LoginBean loginBean) {
		boolean status = false;
		try (Connection conn = JDBCUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("select * from users where username = ? and password = ?")) {
			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getPassword());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return status;
	}
}
