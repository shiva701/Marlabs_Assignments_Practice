package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.demo.model.LoginForm;

/**
 * The Class LoginFormDaoImpl.
 */
public class LoginFormDAOImpl implements LoginFormDAO {

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new login form dao impl.
	 *
	 * @param datasource the datasource
	 */
	@Autowired // constructor injection
	public LoginFormDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	/**
	 * Gets the user.
	 *
	 * @param username the username
	 * @return the user
	 */
	@Override
	public LoginForm getUser(String username) {
		String getUser = "select * from login_form where username=\"" + username+"\"";
		return jdbcTemplate.query(getUser, new ResultSetExtractor<LoginForm>() {

			@Override
			public LoginForm extractData(ResultSet rs) throws SQLException {
				if (rs.next()) {
					LoginForm lf = new LoginForm();
					lf.setUsername(rs.getString("username"));
					lf.setPassword(rs.getString("password"));
					return lf;
				}
				return null;
			}
		});
	}

}
