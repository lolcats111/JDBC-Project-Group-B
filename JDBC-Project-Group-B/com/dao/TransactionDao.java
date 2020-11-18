package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Transaction;
import com.util.DBUtil;

public class TransactionDao {
	
	public static Transaction[] getTransactionsByBankAccount(int accountId) {
		
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("SELECT * from TRANSACTIONS WHERE ACC_ID=?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					
					Transaction transaction = new Transaction(
						rs.getInt("ACC_ID"),
						rs.getString("TXN_TYPE"),
						rs.getDouble("AMOUNT")
					);
					transactions.add(transaction);
				}
			}
			
			DBUtil.closeAllConnection(cn, ps, rs);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
        Transaction[] result = new Transaction[transactions.size()]; 
        result = transactions.toArray(result);

		return result;
	}

}
