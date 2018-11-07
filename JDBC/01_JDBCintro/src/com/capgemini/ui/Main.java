package com.capgemini.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.business.Customer;
import com.capgemini.db.CustomerDAO;
import com.capgemini.db.CustomerDAOImpl;

public class Main {

	private static void displayCustomer() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		CustomerDAO dao = new CustomerDAOImpl();
		List<Customer> customer=dao.getAllCustomers();
		System.out.println(customer);

	}

	private static void updateCustomer() {
		// TODO Auto-generated method stub

	}

	private static void addCustomer() {
		// TODO Auto-generated method stub

	}

	private static void removeCustomer() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		int inp_id = 0;
		CustomerDAO dao = new CustomerDAOImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id to remove");
		inp_id = scanner.nextInt();
		boolean result = dao.removeCustomer(inp_id);
		if (result == true) {
			System.out.println("record deleted sucessfully.....");

		}
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		System.out.println("Customer Application");
		System.out.println("---------------------------------");
		System.out.println("1.Add  New Customer");
		System.out.println("2.Update Customer");
		System.out.println("3.Display All Customer");
		System.out.println("4.Delete Customer");
		System.out.println("5.Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Choice");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			addCustomer();
			break;

		case 2:
			updateCustomer();
			break;

		case 3:
			displayCustomer();
			break;

		case 4:
			removeCustomer();
			break;

		case 5:
			System.out.println("******Thank You*********");
			break;
		}

	}

}
