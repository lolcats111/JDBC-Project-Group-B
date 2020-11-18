package com.service;

import com.bean.BankAccount;
import com.dao.BankAccountDao;

public class BankService {
	public boolean openAccount(BankAccount acc){
		BankAccountDao dao = new BankAccountDao();
		return dao.openAccount(acc);
		
	}
	
	public boolean closeAccount(long accId){
		BankAccountDao dao = new BankAccountDao();
		return dao.closeAccount(accId);		
	}
}
