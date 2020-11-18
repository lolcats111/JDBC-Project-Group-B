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
		
		try {
			testOverdraftTransaction();
			System.out.println("Passed testOverdraftTransaction.");
		} catch (Exception e) {
			System.out.println("Failed testOverdraftTransaction:");
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
	
	public static void testOverdraftTransaction() throws Exception {
		
		CustomerService cs = new CustomerService();
		Customer customer = new Customer("Bob", 'M');
		customer = cs.addCustomer(customer);

		if (customer == null) {
			throw new Exception("Couldn't insert customer");
		}
		
		BankService bs = new BankService();
		BankAccount regularAccount = new BankAccount(customer.getId(), 100, "REGULAR");
		regularAccount = bs.openAccount(regularAccount);
		BankAccount creditAccount = new BankAccount(customer.getId(), 100, "CREDIT");
		creditAccount = bs.openAccount(creditAccount);
		
		if (regularAccount == null || creditAccount == null) {
			throw new Exception("Couldn't insert accounts");
		}
		
		TransactionService ts = new TransactionService();
		boolean transactionResult = ts.withdrawMoney(regularAccount.getAccountId(), 150);
		
		if (transactionResult) {
			throw new Exception("Was able to overdraw with regular account");
		}
		
		transactionResult = ts.withdrawMoney(creditAccount.getAccountId(), 150);
		
		if (!transactionResult) {
			throw new Exception("Couldn't overdraw on credit account");
		}
		
		transactionResult = ts.withdrawMoney(creditAccount.getAccountId(), 50);
		if (transactionResult) {
			throw new Exception("Was able to overdraw with balance < 0");
		}
		
		
	}

}
