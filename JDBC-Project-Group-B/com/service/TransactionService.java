package com.service;

import com.bean.Transaction;
import com.dao.TransactionDao;

public class TransactionService {
	
	// View customer details by Id
    public Transaction[] viewTransactionsByBankAccount(int accountId) {
        TransactionDao dao = new TransactionDao();
        return dao.getTransactionsByBankAccount(accountId);
    }

//    public boolean depositMoney(int acc_id, int amount){
//
//        boolean transactionResult = createTransaction(acc_id, amount);
//        if (!transactionResult){
//            return false;
//        }
//        boolean bankUpdate = addMoneyBank(acc_id, amount);
//        if (!bankUpdate){
//            return false;
//        }
//        return true;
//    }
//    public boolean withdrawMoney(int acc_id, int amount){
//
//        amount = -1*amount;
//        boolean transactionResult = createTransaction(acc_id, amount);
//        if (!transactionResult){
//            return false;
//        }
//        boolean bankUpdate = addMoneyBank(acc_id, amount);
//        if (!bankUpdate){
//            return false;
//        }
//        return true;
//    }

}
