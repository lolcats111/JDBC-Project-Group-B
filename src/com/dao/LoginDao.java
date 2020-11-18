package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;

public class LoginDao {
	public LoginDao() {
		super();
	}

	public byte[] getClarkHash(String username) {
		byte[] clarkHash = null;
		try {
			// Step 2: Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Step 3: Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn.prepareStatement("SELECT password_hash FROM CLERKS WHERE username=?");

			ps.setString(1, username);

			// Step 4: Execute the query and store the result.
			ResultSet rs = ps.executeQuery();

			// Step 5: Iterate the resultset and extract the information.
			if (rs != null) {
				while (rs.next()) {
					clarkHash = rs.getBytes("password_hash");
				}
			}

			// Step 6: Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return clarkHash;
	}

}
