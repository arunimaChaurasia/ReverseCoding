package com.cummins.demoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConn {

private	Connection connection ;
	
	public DataBaseConn() {
		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		

		try {

			connection = DriverManager.getConnection(

					"jdbc:mysql://localhost:3306/reverse", "root", "root123");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("Failed to make connection!");
		}

	}
	public Connection getConnection() {
		return connection;
	}
}
