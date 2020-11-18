package com.test;

import java.util.List;

import com.bean.*;
import com.service.*;

public class BankTester {


	public static void main(String[] args) {
		try {
			testOpenCloseAccount();
			System.out.println("Passed Basic openAccount and closeAccount");

		} catch (Exception e) {
			System.out.println("Failed Basic openAccount and closeAccount");
			System.out.println(e.getMessage());
		}
		
		try {
			 testOpenCloseMultipleAccount();
			System.out.println("Passed Opening multiple Accounts and closeAccount");

		} catch (Exception e) {
			System.out.println("Failed Opening multiple Accounts and closeAccount");
			System.out.println(e.getMessage());
		}

	}
	
	//Simple open and close one account
	public static void testOpenCloseAccount() throws Exception {
		CustomerService customerService = new CustomerService();
		BankService bankService = new BankService();

		Customer bob = new Customer("Bob", 'M');
		Customer bobInserted = customerService.addCustomer(bob);	
		
		if (bobInserted == null) {
			throw new Exception("Couldn't insert bob as a customer");
		}
		
		BankAccount bobAccount = new BankAccount(bobInserted.getId());
		BankAccount bobAccountInserted = bankService.openAccount(bobAccount);
		
		if (bobAccountInserted == null) {
			throw new Exception("Couldn't insert the bank account for Bob");
		}

		if(!bankService.closeAccount(bobAccountInserted.getAccountId())){
			throw new Exception("Couldn't close the bank account for Bob");
		}		
		
	}
	
	//Opening two bank accounts then closing one 
	//Also checking if the remaining bank account is the correct one
	public static void testOpenCloseMultipleAccount() throws Exception {
		CustomerService customerService = new CustomerService();
		BankService bankService = new BankService();

		Customer bob = new Customer("Bob", 'M');
		Customer bobInserted = customerService.addCustomer(bob);	
		
		if (bobInserted == null) {
			throw new Exception("Couldn't insert bob as a customer");
		}
		
		BankAccount bobFirstAccount = new BankAccount(bobInserted.getId(), 100, "REGULAR");
		BankAccount bobSecondAccount = new BankAccount(bobInserted.getId(), 300, "REGULAR");

		BankAccount bobFirstAccountInserted = bankService.openAccount(bobFirstAccount);
		BankAccount bobSecondAccountInserted = bankService.openAccount(bobSecondAccount);

		if ( bobFirstAccountInserted == null) {
			throw new Exception("Couldn't insert the First bank account for Bob");
		}
		
		if ( bobSecondAccountInserted == null) {
			throw new Exception("Couldn't insert the Second bank account for Bob");
		}

		if(!(bankService.getBankAccountFromCustomers(bobInserted.getId()).size() == 2)){
			throw new Exception("There aren't two bank accounts for Bob");
		}
		
		if(!bankService.closeAccount(bobFirstAccountInserted.getAccountId())){
			throw new Exception("Couldn't close the First bank account for Bob");
		}
		
		List <BankAccount> bankAccounts = bankService.getBankAccountFromCustomers(bobInserted.getId());
		if(!(bankAccounts.size() == 1)){
			throw new Exception("There should only be one bank account remaining in Bob's Account");
		}
		
		if(bankAccounts.get(0).getBalance()!= bobSecondAccountInserted.getBalance()){
			throw new Exception("Only the Second bank account should remain in Bob's Account");	
		}
	}


}
