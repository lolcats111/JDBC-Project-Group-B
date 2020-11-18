package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bean.Customer;
import com.service.CustomerService;

class EditCustomerUnit {

	@Test
	void editCustomerName() {
		CustomerService service = new CustomerService();
		
		//Add a customer
		Customer customer = new Customer("Mark", 'M');
		Customer insertedCustomer = service.addCustomer(customer);
		assertNotNull(insertedCustomer);
		
		// Change their name, assert it correctly updates.
		String newName = service.updateCustomerName(insertedCustomer.getId(), "John");
		assertEquals(newName, "John");
	}

}
