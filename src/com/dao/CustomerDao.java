package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Customer;
import com.util.DBUtil;

public class CustomerDao {

	public CustomerDao() {
		super();
	}

	public boolean updateCustomerName(int customerId, String name) {

		boolean result = false;

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("UPDATE CUSTOMERS SET name=? WHERE id=?");

			ps.setString(1, name);
			ps.setInt(2, customerId);

			int n = ps.executeUpdate();
			result = n > 0;

			// Close all the objects in the reverse order of creation
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return result;
	}

	public boolean updateCustomerAddress(int customerId, String address) {

		boolean result = false;

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("UPDATE CUSTOMERS SET address=? WHERE id=?");

			ps.setString(1, address);
			ps.setInt(2, customerId);

			int n = ps.executeUpdate();
			result = n > 0;

			// Close all the objects in the reverse order of creation
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return result;
	}

	public boolean updateCustomerPhone(int customerId, String phone) {

		boolean result = false;

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("UPDATE CUSTOMERS SET phone=? WHERE id=?");

			ps.setString(1, phone);
			ps.setInt(2, customerId);

			int n = ps.executeUpdate();
			result = n > 0;

			// Close all the objects in the reverse order of creation
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return result;
	}

	public boolean updateCustomerGender(int customerId, String gender) {

		boolean result = false;

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("UPDATE CUSTOMERS SET gender=? WHERE id=?");

			ps.setString(1, gender);
			ps.setInt(2, customerId);

			int n = ps.executeUpdate();
			result = n > 0;

			// Close all the objects in the reverse order of creation
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return result;
	}

	public boolean updateCustomerEmail(int customerId, String email) {

		boolean result = false;

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("UPDATE CUSTOMERS SET gender=? WHERE id=?");

			ps.setString(1, email);
			ps.setInt(2, customerId);

			int n = ps.executeUpdate();
			result = n > 0;

			// Close all the objects in the reverse order of creation
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return result;
	}

	public boolean updateCustomerPrivilege(int customerId, String privilege) {

		boolean result = false;

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("UPDATE CUSTOMERS SET is_privileged=? WHERE id=?");

			ps.setString(1, privilege);
			ps.setInt(2, customerId);

			int n = ps.executeUpdate();
			result = n > 0;

			// Close all the objects in the reverse order of creation
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return result;
	}

	public boolean addCustomer(Customer c) {

		boolean result = false;

		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn.prepareStatement(
					"INSERT INTO CUSTOMERS(name,gender,email,phone,address, is_privileged) VALUES(?,?,?,?,?,?)");

			ps.setString(1, c.getName());
			ps.setString(2, String.valueOf(c.getGender()));
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPhone());
			ps.setString(5, c.getAddress());
			ps.setString(6, c.getIsPrivileged());

			// Execute query and store the result.
			int n = ps.executeUpdate();

			// Check if the query is a success or fails.
			if (n > 0) {
				result = true;
			}

			// Close all the objects in the reverse order of its creation.
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public Customer viewCustomerDetails() {
		Customer c = null;
		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM CUSTOMERS WHERE ID=?");

//			ps.setLong(1, cid);

			// Execute the query and store the result.
			ResultSet rs = ps.executeQuery();

			// Iterate the result set and extract the information.
			if (rs != null) {
				while (rs.next()) {
					String name = rs.getString("NAME");
					char gender = rs.getString("GENDER").charAt(0);
					String email = rs.getString("EMAIL");
					String phone = rs.getString("PHONE");
					String address = rs.getString("ADDRESS");
					String isPrivileged = rs.getString("IS_PRIVILEGED");

					c = new Customer(name, gender, email, phone, address, isPrivileged);
				}
			}

			// Close all the objects in the reverse order of its creation.
			DBUtil.closeAllConnection(cn, ps, rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return c;

	}

}