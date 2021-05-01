package com.dilaygulbagce.stockCardApplication.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connect = null;
		
		public static Connection getConnection() throws SQLException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/stock_card?useUnicode=true&characterEncoding=UTF8", "root", "root");
				
			} catch (ClassNotFoundException | SQLException exception) {
	            System.out.println(exception.getMessage());
	        }
			return connect;
		}
}
