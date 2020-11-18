package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import starter.com.bean.Employee;

import com.bean.BankAccount;
import com.bean.Transaction;
import com.util.DBUtil;

public class BankAccountDao {
	
	public BankAccount getBankAccount(int accountId) {
		
		BankAccount account = null;
		
		try {

			Connection cn = DBUtil.createConnection();
			PreparedStatement ps = cn.prepareStatement("SELECT * from ACCOUNTS WHERE id=?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {	
					account = new BankAccount(
							rs.getInt("CUSTOMER_ID"),
							rs.getDouble("BALANCE"),
							rs.getString("SALARY")
					);	
				}
			}
			
			DBUtil.closeAllConnection(cn, ps, rs);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return account;
	}

}
