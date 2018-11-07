package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String dbURL = "jdbc:mysql://localhost:3306/demodb";
		String userName = "root";
		String password = "pass";
		Connection connection = DriverManager.getConnection(dbURL, userName,
				password);
		return connection;
	}

	public static void insertRecord() throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		System.out.println("Connected Sucessfully");
		String SQL = "insert into Customer values(1,'Kiran Traders','pune',2000.00)";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(SQL);
		System.out.println(r + "rows inserted.....");
		statement.close();
		connection.close();
	}

	public static void updateRecord() throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		System.out.println("Updated Sucessfully");
		String SQL = "update Customer set c_amt=c_amt+2000 where c_id=1";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(SQL);
		System.out.println(r + "rows updated.....");
		statement.close();
		connection.close();
	}

	public static void deleteRecord() throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		System.out.println("Deleted Sucessfully");
		String SQL = "delete from Customer where c_id=1";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(SQL);
		System.out.println(r + "rows deleted.....");
		statement.close();
		connection.close();
	}

	public static void displayAllRecords() throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		System.out.println("Displayed Records Succesfully.......");
		String SQL = "Select * from Customer where c_id";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(SQL);
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t\t");
			System.out.print(rs.getString(2) + "\t\t");
			System.out.print(rs.getString(3) + "\t\t");
			System.out.println(rs.getDouble(4));
		}
		rs.close();
		statement.close();
		connection.close();
	}

	public static void displayAllRecords(int id) throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		System.out.println("Displayed Records Succesfully.......");
		String SQL = "Select * from Customer where c_id=" + id;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(SQL);
		if (rs.next()) {
			System.out.print(rs.getInt(1) + "\t\t");
			System.out.print(rs.getString(2) + "\t\t");
			System.out.print(rs.getString(3) + "\t\t");
			System.out.println(rs.getDouble(4));
		}
		rs.close();
		statement.close();
		connection.close();
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// insertRecord();
		// updateRecord();
		// deleteRecord();
		displayAllRecords(5);
		displayAllRecords();

	}
}
