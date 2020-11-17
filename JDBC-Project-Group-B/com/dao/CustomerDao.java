package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Customer;
import com.util.DBUtil;

public class CustomerDao {

		
		public boolean addCustomer(Customer c) {

			boolean result = false;

			try {
				//Create a Connection object
				Connection cn = DBUtil.createConnection();

				//Create a PreparedStatement object using the Connection
				PreparedStatement ps = cn
						.prepareStatement("INSERT INTO CUSTOMERS VALUES(?,?,?,?,?,?)");

				ps.setInt(1, c.getId());
				ps.setString(2, c.getName());
				ps.setString(3, String.valueOf(c.getGender()));
				ps.setString(4, c.getEmail());
				ps.setString(5, c.getPhone());
				ps.setString(6, c.getAddress());
				

				//Execute query and store the result.
				int n = ps.executeUpdate();

				//Check if the query is a success or fails.
				if (n > 0) {
					result = true;
				}

				//Close all the objects in the reverse order of its creation.
				DBUtil.closeAllConnection(cn, ps, null);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return result;
		}
		
		
		public Customer viewCustomerDetails(int cid) {
			Customer c = null;
			try {
				//Create a Connection object
				Connection cn = DBUtil.createConnection();

				//Create a PreparedStatement object using the Connection
				PreparedStatement ps = cn
						.prepareStatement("SELECT * FROM CUSTOMERS WHERE ID=?");

				ps.setLong(1, cid);
				
				//Execute the query and store the result.
				ResultSet rs = ps.executeQuery();
				
				//Iterate the result set and extract the information.
				if (rs != null) {
					while (rs.next()) {
						int id = rs.getInt("ID");
						String name = rs.getString("NAME");
						char gender = rs.getString("GENDER").charAt(0);
						String email = rs.getString("EMAIL");
						String phone = rs.getString("PHONE");
						String address = rs.getString("ADDRESS");
						c = new Customer(id, name, gender, email, phone, address);
					}
				}
				
				//Close all the objects in the reverse order of its creation.
				DBUtil.closeAllConnection(cn, ps, rs);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return c;
				
			}
			
			
			
	}

