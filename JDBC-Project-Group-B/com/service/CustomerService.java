package com.service;

import com.bean.Customer;
import com.dao.CustomerDao;



public class CustomerService {
	
	
	//Add customer
	public boolean addCustomer(Customer c) {
		CustomerDao dao=new CustomerDao();
		return dao.addCustomer(c);
	}
	
	//View customer details by Id
	public Customer viewCustomerDetails(int cid) {
		CustomerDao dao=new CustomerDao();
		return dao.viewCustomerDetails(cid);
	}

	
	
}
