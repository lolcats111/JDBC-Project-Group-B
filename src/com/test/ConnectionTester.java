package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;

public class ConnectionTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		testConnection();

	}

	public static void testConnection() {
		try {
			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getString("DUMMY"));
				}
			}
			DBUtil.closeAllConnection(cn, ps, rs);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
