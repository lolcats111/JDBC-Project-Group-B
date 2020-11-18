package com.service;

import com.bean.Transaction;
import com.dao.TransactionDao;

public class TransactionService {
	
	// View customer details by Id
    public Transaction[] viewTransactionsByBankAccount(int accountId) {
        TransactionDao dao = new TransactionDao();
        return dao.getTransactionsByBankAccount(accountId);
    }

}
