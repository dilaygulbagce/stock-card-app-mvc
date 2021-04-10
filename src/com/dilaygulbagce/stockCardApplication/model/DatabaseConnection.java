package com.dilaygulbagce.stockCardApplication.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private Connection connect = null;
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_card?useUnicode=true&characterEncoding=UTF8", "root", "");
			
		} catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
		return connect;
	}
	
}