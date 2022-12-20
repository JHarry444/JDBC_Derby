package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Runner {

	public static void main(String[] args) throws Exception {
		String urlConnection = "jdbc:derby:memory:qa;create=true";
		Connection con = DriverManager.getConnection(urlConnection);
		Statement statement = con.createStatement();
		String sql = "CREATE TABLE authors (id INT PRIMARY KEY,first_name VARCHAR(255),last_name VARCHAR(255))";
		statement.execute(sql);
		sql = "INSERT INTO authors VALUES (1, 'arash','ariani')";
		statement.execute(sql);
		ResultSet rs = statement.executeQuery("SELECT * FROM authors");
		rs.next();
		System.out.println("Name: " + rs.getString(2));
	}

}
