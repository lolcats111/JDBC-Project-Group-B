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
}
