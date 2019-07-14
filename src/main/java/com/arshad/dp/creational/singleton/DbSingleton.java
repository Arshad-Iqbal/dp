package com.arshad.dp.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

	private static volatile DbSingleton instance = null;
	private static volatile Connection conn = null;

	private DbSingleton() {

		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (conn != null) { // Prevent object being created through reflection
			throw new RuntimeException("Use getConnection() to create object!");
		}
		if (instance != null) { // Prevent object being created through reflection
			throw new RuntimeException("Use getInstance() to create object!");
		}

	}

	public static DbSingleton getInstance() {

		if (instance == null) {
			synchronized (DbSingleton.class) {
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}

		return instance;
	}

	public Connection getConnection() {

		if (conn == null) {
			synchronized (DbSingleton.class) {
				if (conn == null) {
					String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
					try {
						conn = DriverManager.getConnection(dbUrl);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
}
