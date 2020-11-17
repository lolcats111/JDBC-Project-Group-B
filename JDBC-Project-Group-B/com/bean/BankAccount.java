package com.bean;
//Test
public class BankAccount {
	private int accountId;
	private int customerId;
	private double balance;
	private String accountType;
	public BankAccount(int accountId, int customerId, double balance, String accountType) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public BankAccount(int accountId, int customerId) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.balance = 0;
		this.accountType = "REGULAR";
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
