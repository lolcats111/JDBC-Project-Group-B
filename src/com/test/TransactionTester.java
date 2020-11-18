package com.test;

import com.bean.*;
import com.service.*;

public class TransactionTester {

	public static void main(String[] args) {

		try {
			testGetTransactionsByAccount();
			System.out.println("Passed testGetTransactionsByAccount.");
		} catch (Exception e) {
			System.out.println("Failed testGetTransactionsByAccount:");
			System.out.println(e.getMessage());
		}
		

	}
	
	public static void testGetTransactionsByAccount() throws Exception {
		
		CustomerService cs = new CustomerService();
		Customer customer = new Customer("Alice", 'F');
		customer = cs.addCustomer(customer);

		if (customer == null) {
			throw new Exception("Couldn't insert customer");
		}
		
		BankService bs = new BankService();
		BankAccount account = new BankAccount(customer.getId(), 100, "REGULAR");
		account = bs.openAccount(account);
		
		if (account == null) {
			throw new Exception("Couldn't insert account");
		}
		
		TransactionService ts = new TransactionService();
		boolean transactionResult = ts.depositMoney(account.getAccountId(), 25);
		
		if (!transactionResult) {
			throw new Exception("Couldn't make transaction");
		}
		
		Transaction[] transactions = ts.viewTransactionsByBankAccount(account.getAccountId());
		
		if (transactions.length == 0) {
			throw new Exception("Transaction list is empty");
		}
		
		if (transactions[0].getAmount() != 25) {
			throw new Exception("Transaction list is incorrect");
		}
		
	}

}
