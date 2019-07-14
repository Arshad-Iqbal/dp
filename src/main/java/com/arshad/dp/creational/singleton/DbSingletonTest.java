package com.arshad.dp.creational.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonTest {

	public static void main(String[] args) {
		DbSingleton instance = DbSingleton.getInstance();
		long beforeTime = 0;
		long afterTime = 0;
		System.out.println(instance);
		beforeTime = System.currentTimeMillis();
		Connection con = instance.getConnection();
		afterTime = System.currentTimeMillis();
		System.out.println(afterTime - beforeTime);
		
		Statement st;

		try {
			st = con.createStatement();
			int count = st.executeUpdate("CREATE TABLE Address(ID int, streetName varchar(20),city varchar(20))");
			System.out.println("Table created.");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		beforeTime = System.currentTimeMillis();
		con = instance.getConnection();
		afterTime = System.currentTimeMillis();
		System.out.println(afterTime - beforeTime);
	}
}
