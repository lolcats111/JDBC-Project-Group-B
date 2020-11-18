package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.BankAccount;
import com.util.DBUtil;

public class BankAccountDao {

    public int getCurrentBalance (int acc_id){
        int balance = -1;
        try {
            // Create a Connection object
            Connection cb = DBUtil.createConnection();

            // Create a PreparedStatement object using the Connection
            PreparedStatement gcb = cb.prepareStatement("SELECT * FROM BANK_ACCOUNTS WHERE acc_id=?");

            gcb.setLong(1, acc_id);

            // Execute the query and store the result.
            ResultSet rs = gcb.executeQuery();

            // Iterate the result set and extract the information.
            if (rs != null) {
                while (rs.next()) {
                    balance = rs.getInt("balance");
                }
            }

            // Close all the objects in the reverse order of its creation.
            DBUtil.closeAllConnection(cb, gcb, rs);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return balance;
    }

    public boolean addMoneyBank (int acc_id, int amount){
        int current_balance = getCurrentBalance(acc_id);
        if (current_balance == -1){
            return false;
        }
        boolean result = false;
        try {
            Connection cn = DBUtil.createConnection();
            PreparedStatement ps = cn.prepareStatement("UPDATE BANK_ACCOUNTS SET balance=? WHERE acc_id=?");
            int new_balance = current_balance + amount;

            ps.setInt(1, new_balance);
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

}
