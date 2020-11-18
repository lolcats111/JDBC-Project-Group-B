package com.test;

import com.bean.*;
import com.service.*;

public class BankTester {


	public static void main(String[] args) {
		try {
			testOpenCloseAccount();
			System.out.println("Passed openAccount and closeAccount");

		} catch (Exception e) {
			System.out.println("Failed openAccount and closeAccount");
			System.out.println(e.getMessage());
		}

	}
	
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


}
