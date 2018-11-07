package com.capgemini.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.business.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCustomer(int customerId)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionManager.createConnection();
		String sql = "delete from Customer where c_id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		int inp_id = 0;
		statement.setInt(1, inp_id);
		int r = statement.executeUpdate();
		if (r > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws ClassNotFoundException,
			SQLException {

		Connection connection = ConnectionManager.createConnection();
		String sql = "Select * from Customer";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Customer> customer = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String city = rs.getString(3);
			double amt = rs.getDouble(4);
			Customer customer1 = new Customer();
			customer1.setId(id);
			customer1.setName(name);
			customer1.setCity(city);
			customer1.setOutStandingAmount(amt);
			customer.add(customer1);

		}
		statement.close();
		rs.close();
		ConnectionManager.closeConnection(connection);

		return customer;
	}

}
