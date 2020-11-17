package com.service;

import com.bean.Customer;
import com.dao.CustomerDao;

public class CustomerService {

    public CustomerService() {
        super();
    }

    // Add customer
    public boolean addCustomer(Customer c) {
        CustomerDao dao = new CustomerDao();
        return dao.addCustomer(c);
    }

    // View customer details by Id
    public Customer viewCustomerDetails(int cid) {
        CustomerDao dao = new CustomerDao();
        return dao.viewCustomerDetails(cid);
    }

    // Update customer name
    public String updateCustomerName(int cid, String name) {
        CustomerDao dao = new CustomerDao();
        boolean t = dao.updateCustomerName(cid, name);
        if (t) {
            Customer c = viewCustomerDetails(cid);
            return c.getName();
        }
        return null;
    }

    // Update customer phone
    public String updateCustomerPhone(int cid, String phone) {
        CustomerDao dao = new CustomerDao();
        boolean t = dao.updateCustomerPhone(cid, phone);
        if (t) {
            Customer c = viewCustomerDetails(cid);
            return c.getPhone();
        }
        return null;
    }

    // Update customer email
    public String updateCustomerEmail(int cid, String email) {
        CustomerDao dao = new CustomerDao();
        boolean t = dao.updateCustomerEmail(cid, email);
        if (t) {
            Customer c = viewCustomerDetails(cid);
            return c.getEmail();
        }
        return null;
    }

    // Update customer gender
    public char updateCustomerGender(int cid, String gender) {
        CustomerDao dao = new CustomerDao();
        boolean t = dao.updateCustomerGender(cid, gender);
        if (t) {
            Customer c = viewCustomerDetails(cid);
            return c.getGender();
        }
        return null;
    }

    
}
