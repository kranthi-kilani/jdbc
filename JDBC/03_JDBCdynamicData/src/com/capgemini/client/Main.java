package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
		int inp_id = 0;
		String inp_name = " ";
		String inp_city = " ";
		double inp_amt = 0.0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Id: ");
		inp_id = scanner.nextInt();
		System.out.print("Enter the Name: ");
		inp_name = scanner.next();
		System.out.print("Enter the City: ");
		inp_city = scanner.next();
		System.out.print("Enter the  Outstanding amount: ");
		inp_amt = scanner.nextDouble();

		Connection connection = createConnection();
		System.out.println("Connected Sucessfully");
		String SQL = "insert into Customer values(?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1, inp_id);
		statement.setString(2, inp_name);
		statement.setString(3, inp_city);
		statement.setDouble(4, inp_amt);
		int r = statement.executeUpdate();
		System.out.println(r + "rows inserted.....");
		statement.close();
		connection.close();
	}

	public static void updateRecord() throws ClassNotFoundException,
			SQLException {
		Scanner scanner = new Scanner(System.in);
		Connection connection = createConnection();
		double inp_amt = 0.0;
		int inp_id=0;
		System.out.print("Enter the id: ");
		inp_amt = scanner.nextInt();
		System.out.print("Enter the amount: ");
		inp_amt = scanner.nextDouble();
		String SQL = "update Customer set c_amt=c_amt+? where c_id=?";
		System.out.println("Updated Sucessfully");
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setDouble(1, inp_amt);
		statement.setInt(2, inp_id);
		int r = statement.executeUpdate();

	
		System.out.println(r + "rows updated.....");
		statement.close();
		connection.close();
	}

	public static void deleteRecord() throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		int inp_id = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Id: ");
		inp_id = scanner.nextInt();
		String SQL = "delete from Customer where c_id=?";
		System.out.println("Deleted Sucessfully");
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1, inp_id);
		int rs = statement.executeUpdate();
		System.out.println(rs + "rows deleted.....");
		statement.close();
		connection.close();
	}

	public static void displayAllRecords() throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		System.out.println("Displayed Records Succesfully.......");
		String SQL = "Select * from Customer where c_id=";
		PreparedStatement statement = connection.prepareStatement(SQL);
	
		ResultSet rs = statement.executeQuery();
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

	public static void displayOneRecords(int id) throws ClassNotFoundException,
			SQLException {

		Connection connection = createConnection();
		System.out.println("Displayed Records Succesfully.......");
		String SQL = "Select * from Customer where c_id=?" ;
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
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
		 //insertRecord();
		 updateRecord();
		//deleteRecord();
		 //displayOneRecords(105);
		// displayAllRecords();

	}
}
