package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

public class DBConnection {
	
	private static final String URL="jdbc:mysql://localhost:3306/login_db";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	public static Connection getConnection() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
