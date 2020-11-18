package com.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.dao.CreateAccountDao;

public class CreateAccountService {
	public CreateAccountService() {
		super();
	}

	public boolean createAccount(String username, String password) throws NoSuchAlgorithmException {
		// Get the users password hash from the db, if it exists
		CreateAccountDao dao = new CreateAccountDao();

		// Generate MD5 hash of the given password
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();

		boolean succeeded = dao.createAccount(username, digest);

		return succeeded;
	}

}
