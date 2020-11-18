package com.service;

import com.bean.BankAccount;
import com.dao.BankAccountDao;

public class BankService {
	public BankService(){
		super();
	}
	public boolean openAccount(BankAccount acc){
		BankAccountDao dao = new BankAccountDao();
		return dao.openAccount(acc);
	}
	
	public boolean closeAccount(int accId){
		BankAccountDao dao = new BankAccountDao();
		return dao.closeAccount(accId);		
	}
	public boolean increaseBankBalance (int acc_id, int amount){
		BankAccountDao bankDao = new BankAccountDao();
		return bankDao.addMoneyBank(acc_id, amount);
	}
	public boolean decreaseBankBalance (int acc_id, int amount){
		amount = -1*amount;
		BankAccountDao bankDao = new BankAccountDao();
		return bankDao.addMoneyBank(acc_id, amount);
	}
}
