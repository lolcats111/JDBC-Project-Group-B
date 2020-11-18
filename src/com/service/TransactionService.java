package com.service;

import com.bean.BankAccount;
import com.bean.Transaction;
import com.dao.TransactionDao;

public class TransactionService {

	// View customer details by Id
	public Transaction[] viewTransactionsByBankAccount(int accountId) {
		TransactionDao dao = new TransactionDao();
		return dao.getTransactionsByBankAccount(accountId);
	}

	public boolean depositMoney(int acc_id, int amount) {
		TransactionDao transactionDao = new TransactionDao();
		boolean transactionResult = transactionDao.createTransaction(acc_id, amount);
		if (!transactionResult) {
			return false;
		}
		BankService bankService = new BankService();
		return bankService.increaseBankBalance(acc_id, amount);

	}

	public boolean withdrawMoney(int acc_id, int amount) {
		
		boolean result = false;
		
		BankService bankService = new BankService();
		BankAccount account = bankService.viewBankAccountDetails(acc_id);
		double balance = account.getBalance();
		
		if ((balance >= amount) || (account.getAccountType() == "CREDIT" && balance >= 0)){
			int transaction_amount = -1 * amount;
			TransactionDao transactionDao = new TransactionDao();
			boolean transactionResult = transactionDao.createTransaction(acc_id, amount);
			if (!transactionResult) {
				return false;
			}
			result = bankService.decreaseBankBalance(acc_id, amount);
		}
		
		return result;

	}
}
