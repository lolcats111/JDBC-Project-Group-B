package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBUtil;


public class CustomerDao {

	public CustomerDao(){
		super();
	}

	public boolean updateCustomerName(int customerId, String name) {

		boolean result = false;

		try {
				
			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn
					.prepareStatement("UPDATE CUSTOMERS SET name=? WHERE id=?");
			
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
			PreparedStatement ps = cn
					.prepareStatement("UPDATE CUSTOMERS SET address=? WHERE id=?");
			
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
			PreparedStatement ps = cn
					.prepareStatement("UPDATE CUSTOMERS SET phone=? WHERE id=?");
			
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
			PreparedStatement ps = cn
					.prepareStatement("UPDATE CUSTOMERS SET gender=? WHERE id=?");
			
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
			PreparedStatement ps = cn
					.prepareStatement("UPDATE CUSTOMERS SET gender=? WHERE id=?");
			
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


}
