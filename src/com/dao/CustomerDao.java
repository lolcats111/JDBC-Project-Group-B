package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.bean.Transaction;
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
			PreparedStatement ps = cn.prepareStatement("UPDATE CUSTOMERS SET email=? WHERE id=?");

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

	public Customer addCustomer(Customer c) {

		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Insert into the table
			PreparedStatement ps_ins = cn.prepareStatement(
					"INSERT INTO CUSTOMERS (name,gender,email,phone,address,is_privileged) VALUES (?,?,?,?,?,?)");

			ps_ins.setString(1, c.getName());
			ps_ins.setString(2, String.valueOf(c.getGender()));
			ps_ins.setString(3, c.getEmail());
			ps_ins.setString(4, c.getPhone());
			ps_ins.setString(5, c.getAddress());
			ps_ins.setString(6, c.getIsPrivileged());

			ps_ins.execute();

			// Get the id of the inserted customer
			PreparedStatement ps_getid = cn.prepareStatement("select max(id) as id from CUSTOMERS");
			ResultSet rs = ps_getid.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					c.setId(id);
				}
			} else {

				return null;
			}

			// Close all the objects in the reverse order of its creation.
			DBUtil.closeAllConnection(cn, ps_ins, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return c;
	}

	public Customer viewCustomerDetails(int cid) {
		Customer c = null;
		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM CUSTOMERS WHERE ID=?");
			ps.setInt(1, cid);
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
	
	public Customer[] listCustomers() {

		ArrayList<Customer> customers = new ArrayList<Customer>();

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("SELECT * from CUSTOMERS");
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					Customer customer = new Customer(
							rs.getString("NAME"),
							rs.getString("GENDER").charAt(0),
							rs.getString("EMAIL"),
							rs.getString("PHONE"),
							rs.getString("ADDRESS"),
							rs.getString("IS_PRIVILEGED")
					);
					
					customer.setId(rs.getInt("ID"));
					
					customers.add(customer);
				}
				
			}

			DBUtil.closeAllConnection(cn, ps, rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		Customer[] result = new Customer[customers.size()];
		result = customers.toArray(result);

		return result;
	}

}