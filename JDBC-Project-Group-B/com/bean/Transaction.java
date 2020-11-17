package com.bean;

import java.sql.Date;

public class Transaction {

	private int transactionId;
	private int accountId;
	private Date ts;
	private String type;
	private double amount;
	
	public Transaction(int transactionId, int accountId, String type, double amount) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		long msSinceEpoch = System.currentTimeMillis();
		this.ts = new Date(msSinceEpoch);
		this.type = type;
		this.amount = amount;
	}
	

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
