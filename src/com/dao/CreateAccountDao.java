package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBUtil;

public class CreateAccountDao {
	public CreateAccountDao() {
		super();
	}

	public boolean createAccount(String username, byte[] passwordHash) {

		boolean result = false;

		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn.prepareStatement("INSERT INTO CLERKS VALUES(?,?)");

			ps.setString(1, username);
			ps.setBytes(2, passwordHash);

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

}
