package com.capgemini.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection createConnection() throws SQLException,
			ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/demodb";
		String userName = "root";
		String password = "pass";
		Connection connection = DriverManager.getConnection(dbURL, userName,
				password);
		return connection;
	}

	public static void closeConnection(Connection connection)
			throws SQLException {
		connection.close();
	}


}
