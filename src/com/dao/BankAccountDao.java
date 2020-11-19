package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BankAccount;
import com.bean.Transaction;
import com.util.DBUtil;

public class BankAccountDao {

	public BankAccountDao() {
		super();
	}

	
	public List<BankAccount> getBankAccountsFromCustomers(int customerId) {

		List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("SELECT * from BANK_ACCOUNTS WHERE CUSTOMER_ID=?");
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					BankAccount account = new BankAccount(rs.getInt("ACC_ID"),rs.getInt("CUSTOMER_ID"), rs.getDouble("BALANCE"), rs.getString("ACC_TYPE"));
					bankAccounts.add(account);
				}
			}

			DBUtil.closeAllConnection(cn, ps, rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return bankAccounts;
	}
	
	public BankAccount viewBankAccountDetails(int accountId) {

		BankAccount account = null;

		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("SELECT * from BANK_ACCOUNTS WHERE ACC_ID=?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					account = new BankAccount(rs.getInt("CUSTOMER_ID"), rs.getDouble("BALANCE"),
							rs.getString("ACC_TYPE"));
				}
			}

			DBUtil.closeAllConnection(cn, ps, rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return account;
	}

	public BankAccount openAccount(BankAccount account) {

		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("INSERT INTO BANK_ACCOUNTS(customer_id, balance, acc_type) VALUES(?,?,?)");

			ps.setLong(1, account.getCustomerId());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getAccountType());

			// Execute the query and store the result.
			ps.executeUpdate();
			
			// Get the id of the inserted customer
			PreparedStatement ps_getid = cn.prepareStatement("select max(ACC_ID) as id from BANK_ACCOUNTS");
			ResultSet rs = ps_getid.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					account.setAccountId(id);
				}
			} else {

				return null;
			}

			// Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return account;
	}
//    public int getCurrentBalance (int acc_id){
//        int balance = -1;
//        try {
//            // Create a Connection object
//            Connection cb = DBUtil.createConnection();
//
//            // Create a PreparedStatement object using the Connection
//            PreparedStatement gcb = cb.prepareStatement("SELECT balance INTO result_balance FROM BANK_ACCOUNTS WHERE acc_id=?");
//
//            gcb.setLong(1, acc_id);
//
//            // Execute the query and store the result.
//            ResultSet rs = gcb.executeQuery();
//
////            // Iterate the result set and extract the information.
//            if (rs != null) {
//                while (rs.next()) {
//                    balance = result_balance;
//                }
//            }
//
//            // Close all the objects in the reverse order of its creation.
//            DBUtil.closeAllConnection(cb, gcb, rs);
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return balance;
//    }

	public boolean addMoneyBank(int acc_id, double amount) {
//        int current_balance = getCurrentBalance(acc_id);
//        if (current_balance == -1){
//            return false;
//        }
		boolean result = false;
		try {
			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("UPDATE BANK_ACCOUNTS SET balance= balance + ? WHERE acc_id=?");
//            int new_balance = current_balance + amount;

			ps.setDouble(1, amount);
			ps.setInt(2, acc_id);

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

	public boolean closeAccount(int accId) {

		boolean result = false;

		try {
			// Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn.prepareStatement("DELETE FROM BANK_ACCOUNTS WHERE acc_id=?");

			ps.setLong(1, accId);

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
