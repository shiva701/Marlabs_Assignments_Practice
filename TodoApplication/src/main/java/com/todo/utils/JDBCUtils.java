package com.todo.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * The Class JDBCUtils.
 */
public class JDBCUtils {

	/** The url. */
	private static String url = "jdbc:mysql://localhost:3306/tasks";
	
	/** The uname. */
	private static String uname = "root";
	
	/** The pwd. */
	private static String pwd = "admin1234";

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uname, pwd);
			System.out.println("connection object: " + conn);
		} catch (Exception e) {
			System.err.println("The error in get connection is: " + e);
		}
		return conn;
	}

	/**
	 * Prints the SQL exception.
	 *
	 * @param ex the ex
	 */
	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	/**
	 * Gets the SQL date.
	 *
	 * @param date the date
	 * @return the SQL date
	 */
	public static Date getSQLDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}

	/**
	 * Gets the util date.
	 *
	 * @param date the date
	 * @return the util date
	 */
	public static LocalDate getUtilDate(java.sql.Date date) {
		return date.toLocalDate();
	}

}
