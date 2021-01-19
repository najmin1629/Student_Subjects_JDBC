package com.practice.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPostgresConnection {
	private final String url = "jdbc:postgresql://localhost/test";
	private final String user = "postgres";
	private final String password = "Najmin@1947";
	
	public Connection connect()
	{
		Connection connection = null;
		try {
			connection=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
