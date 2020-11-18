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

		try {
			editCustomerPrivilege();
			System.out.println("Passed editCustomerPrivilege.");
		} catch (Exception e) {
			System.out.println("Failed editCustomerPrivilege:");
			System.out.println(e.getMessage());
		}

		try {
			editCustomerPhone();
			System.out.println("Passed editCustomerPhone.");
		} catch (Exception e) {
			System.out.println("Failed editCustomerPhone:");
			System.out.println(e.getMessage());
		}

		try {
			editCustomerAddress();
			System.out.println("Passed editCustomerAddress.");
		} catch (Exception e) {
			System.out.println("Failed editCustomerAddress:");
			System.out.println(e.getMessage());
		}
	}

	public static void editCustomerName() throws Exception {
		CustomerService service = new CustomerService();

		// Add a customer
		Customer customer = new Customer("Pork", 'M');
		Customer insertedCustomer = service.addCustomer(customer);
		if (insertedCustomer == null) {
			throw new Exception("Couldn't insert customer");
		}

		// Change their name, assert it correctly updates.
		String newName = service.updateCustomerName(insertedCustomer.getId(), "John");
		if (newName == null || !newName.equals("John")) {
			throw new Exception("Couldn't update customer name");
		}

	}

	public static void editCustomerEmail() throws Exception {
		CustomerService service = new CustomerService();

		// Add a customer
		Customer customer = new Customer("Mary", 'F');
		customer.setEmail("email@email.com");
		Customer insertedCustomer = service.addCustomer(customer);

		if (insertedCustomer == null) {
			throw new Exception("Couldn't insert customer");
		}

		// Change their name, assert it correctly updates.
		String newName = service.updateCustomerEmail(insertedCustomer.getId(), "newemail@email.com");
		if (newName == null || !newName.equals("newemail@email.com")) {
			throw new Exception("Couldn't update customer email");
		}

	}

	public static void editCustomerGender() throws Exception {
		CustomerService service = new CustomerService();

		// Add a customer
		Customer customer = new Customer("Mary", 'F');
		Customer insertedCustomer = service.addCustomer(customer);

		if (insertedCustomer == null) {
			throw new Exception("Couldn't insert customer");
		}

		// Change their name, assert it correctly updates.
		String newGender = service.updateCustomerGender(insertedCustomer.getId(), "M");
		if (newGender == null || !newGender.equals("M")) {
			throw new Exception("Couldn't update customer gender");
		}

	}

	public static void editCustomerPrivilege() throws Exception {
		CustomerService service = new CustomerService();

		// Add a customer
		Customer customer = new Customer("Mary", 'F');
		Customer insertedCustomer = service.addCustomer(customer);

		if (insertedCustomer == null) {
			throw new Exception("Couldn't insert customer");
		}

		// Change their name, assert it correctly updates.
		String newPriv = service.updateCustomerPrivilege(insertedCustomer.getId(), "Y");
		if (newPriv == null || !newPriv.equals("Y")) {
			throw new Exception("Couldn't update customer privilege");
		}

	}

	public static void editCustomerPhone() throws Exception {
		CustomerService service = new CustomerService();

		// Add a customer
		Customer customer = new Customer("Wendy", 'F');
		customer.setPhone("111");
		Customer insertedCustomer = service.addCustomer(customer);

		if (insertedCustomer == null) {
			throw new Exception("Couldn't insert customer");
		}

		// Change their name, assert it correctly updates.
		String newPhone = service.updateCustomerPhone(insertedCustomer.getId(), "222");
		if (newPhone == null || !newPhone.equals("222")) {
			throw new Exception("Couldn't update customer phone");
		}

	}

	public static void editCustomerAddress() throws Exception {
		CustomerService service = new CustomerService();

		// Add a customer
		Customer customer = new Customer("Wow", 'M');
		customer.setAddress("1 Greenfield Way");
		Customer insertedCustomer = service.addCustomer(customer);

		if (insertedCustomer == null) {
			throw new Exception("Couldn't insert customer");
		}

		// Change their name, assert it correctly updates.
		String newAddress = service.updateCustomerAddress(insertedCustomer.getId(), "Moon");
		if (newAddress == null || !newAddress.equals("Moon")) {
			throw new Exception("Couldn't update customer address");
		}

	}

}
