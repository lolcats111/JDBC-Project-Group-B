package com.test;

import com.bean.Customer;
import com.service.CustomerService;

public class CustomerTester {
	public static void main(String[] args) {
		
		try {
			editCustomerName();
			System.out.println("Passed editCustomerName.");
		} catch (Exception e) {
			System.out.println("Failed editCustomerName:");
			System.out.println(e.getMessage());
		}
		
		
		
		try {
			editCustomerEmail();
			System.out.println("Passed editCustomerEmail.");
		} catch (Exception e) {
			System.out.println("Failed editCustomerEmail:");
			System.out.println(e.getMessage());
		}
		
		
		try {
			editCustomerGender();
			System.out.println("Passed editCustomerGender.");
		} catch (Exception e) {
			System.out.println("Failed editCustomerGender:");
			System.out.println(e.getMessage());
		}
	}
	
	public static void editCustomerName() throws Exception {
		CustomerService service = new CustomerService();
		
		//Add a customer
		Customer customer = new Customer("Pork", 'M');
		Customer insertedCustomer = service.addCustomer(customer);
		if(insertedCustomer==null) {
			throw new Exception("Couldn't insert customer");
		}
		
		// Change their name, assert it correctly updates.
		String newName = service.updateCustomerName(insertedCustomer.getId(), "John");
		if(newName==null || !newName.equals("John")) {
			throw new Exception("Couldn't update customer name");
		}
		
	}
	
	public static void editCustomerEmail() throws Exception {
		CustomerService service = new CustomerService();
		
		//Add a customer
		Customer customer = new Customer("Mary", 'F');
		customer.setEmail("email@email.com");
		Customer insertedCustomer = service.addCustomer(customer);
		
		if(insertedCustomer==null) {
			throw new Exception("Couldn't insert customer");
		}
		
		// Change their name, assert it correctly updates.
		String newName = service.updateCustomerEmail(insertedCustomer.getId(), "newemail@email.com");
		if(newName==null || !newName.equals("newemail@email.com")) {
			throw new Exception("Couldn't update customer email");
		}
		
	}


	public static void editCustomerGender() throws Exception {
		CustomerService service = new CustomerService();
		
		//Add a customer
		Customer customer = new Customer("Mary", 'F');
		Customer insertedCustomer = service.addCustomer(customer);
		
		if(insertedCustomer==null) {
			throw new Exception("Couldn't insert customer");
		}
		
		// Change their name, assert it correctly updates.
		String newGender = service.updateCustomerGender(insertedCustomer.getId(), "M");
		if(newGender==null || !newGender.equals("M")) {
			throw new Exception("Couldn't update customer gender");
		}
		
	}
	
}
