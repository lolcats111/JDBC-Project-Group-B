package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.Transaction;
import com.util.DBUtil;

public class TransactionDao {

    public boolean createTransaction (int acc_id, int amount){
//    public boolean depositMoney(Transaction c){
        boolean result = false;
        Transaction new_trans = new Transaction(acc_id, amount);
        try {
            Connection cn = DBUtil.createConnection();
            int record_amount = (int) new_trans.getAmount();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO TRANSACTIONS (acc_id, txn_type, amount) VALUES(?,?,?)");
            ps.setInt(1, new_trans.getAccountId());
            ps.setString(2, new_trans.getType());
            ps.setInt(3, record_amount);

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
