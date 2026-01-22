package com.example.demo.util;
import java.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:h2:file:./data/testdb";
			String user = "sa";
			String password = "";
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	
	
	/*
	 private static final String URL = "jdbc:h2:file:./data/testdb";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	 */
}
