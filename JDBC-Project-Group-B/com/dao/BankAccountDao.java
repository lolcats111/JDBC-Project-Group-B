package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.BankAccount;
import com.util.DBUtil;

public class BankAccountDao {
	
	public boolean openAccount (BankAccount account){
		boolean result = false;

		try {
			//Create a Connection object
			Connection cn = DBUtil.createConnection();

			//Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("INSERT INTO BANK_ACCOUNTS(customer_id, balance, acc_type) VALUES(?,?,?)");

			ps.setLong(1, account.getCustomerId());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getAccountType());

			//Execute the query and store the result.
			int n = ps.executeUpdate();

			//Check the query is success or fail.
			if (n > 0) {
				result = true;
			}

			//Close all the objects in the reverse order of its
			//creation.
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public boolean closeAccount(long bankNo) {

		boolean result = false;

		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("DELETE FROM BANK_ACCOUNTS WHERE acc_id=?");

			ps.setLong(1, bankNo);

			// Execute the query and store the result.
			int n = ps.executeUpdate();

			// Check the query is success or fail.
			if (n > 0) {
				result = true;
			}

			// Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}