package com.capgemini.db;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.business.Customer;

public interface CustomerDAO {

	boolean addCustomer(Customer customer);
	boolean removeCustomer(int customerId) throws ClassNotFoundException, SQLException;
	boolean updateCustomer(Customer customer);
	Customer findCustomer(int customerId);
	List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException;
}
