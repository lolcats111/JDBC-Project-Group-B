package com.bean;

public class Clerk {
	private String username;
	private byte[] passwordHash;
	
	
	public Clerk(String username, byte[] passwordHash) {
		this.username = username;
		this.passwordHash = passwordHash;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	
	
}
