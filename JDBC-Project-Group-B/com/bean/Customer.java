package com.bean;

public class Customer {
	private int id;
	private String name;
	private char gender;
	private String email;
	private String phone;
	private String address;
	
	public Customer(int id, String name, char gender, String email, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public Customer(int id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
