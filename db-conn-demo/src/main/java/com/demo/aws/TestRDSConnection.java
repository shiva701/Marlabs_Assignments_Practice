package com.demo.aws;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestRDSConnection {

	static Connection conn;
	static Statement smt;
	
	TestRDSConnection(){
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root","admin1234");
			if(conn!=null) {
				System.out.println("Connection done!!");
			}
		}catch(Exception e) { 
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new TestRDSConnection();
//		try {
//			smt = conn.createStatement();
////			PreparedStatement prepStmt  = conn.prepareStatement("insert into student value (?,?,?)");
////			prepStmt.setInt(1, 5);
////			prepStmt.setString(2, "manturgi");
////			prepStmt.setString(3, "santa clara");
////			prepStmt.addBatch();
////			prepStmt.setInt(1, 6);
////			prepStmt.setString(2, "banti");
////			prepStmt.setString(3, "leesburg");
////			prepStmt.addBatch();
////			int[] executeBatch = prepStmt.executeBatch();
////			System.out.println("row inserted: " + Arrays.toString(executeBatch));
////			smt.execute("create table student (id int, name varchar(50));");
////			smt.executeUpdate("insert into student value (3, 'pflugerville', 'shiva shukla')");
//			
//			PreparedStatement update = conn.prepareStatement("update student set name = ? where studentId = ?");
//			update.setString(1, "banti");
//			update.setInt(2, 6);
//			update.executeUpdate();
//			System.out.println("row updated");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try(
				CallableStatement call = conn.prepareCall("CALL getUserInfo()");
				ResultSet rs = call.executeQuery();
				){
			while(rs.next()) {
				System.out.println("ID::" + rs.getInt(1) + " address::" + rs.getString(2) + " name::" + rs.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
