package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	static String host = "localhost";
	static int port = 1521;
	static String user = "SYSTEM"; // TCSoracle for most
	static String password = "password";
	static String service = "server"; // XE if you have experss edition, something else otherwise.

	static String url = String.format("jdbc:oracle:thin:%s/%s@//%s:%d/%s", user, password, host, port, service);

	public static Connection createConnection() {
		Connection cn = null;
		try {
			// Step 1: Initialize the jdbc driver.
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step 2: Create a Connection object
			cn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}

	public static void closeAllConnection(Connection cn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (cn != null) {
				cn.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
