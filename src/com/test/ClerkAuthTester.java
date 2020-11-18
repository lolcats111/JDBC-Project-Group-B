package com.test;

import java.nio.charset.Charset;
import java.util.Random;

import com.service.CreateAccountService;
import com.service.LoginService;

public class ClerkAuthTester {

	public static void main(String[] args) {
		try {
			createAccount();
			System.out.println("Passed createAccount.");
		} catch (Exception e) {
			System.out.println("Failed createAccount:");
			System.out.println(e.getMessage());
		}

		try {
			login();
			System.out.println("Passed login.");
		} catch (Exception e) {
			System.out.println("Failed login:");
			System.out.println(e.getMessage());
		}
	}

	public static String randomUser(int length) {
		byte[] array = new byte[length];
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));

		return generatedString;
	}

	public static void createAccount() throws Exception {
		CreateAccountService service = new CreateAccountService();

		// Check you can make a new account
		boolean success = service.createAccount(randomUser(10), "password");
		if (!success) {
			throw new Exception("Couldn't make an account.");
		}

	}

	public static void login() throws Exception {
		CreateAccountService accService = new CreateAccountService();

		// Check you can make a new account
		String username = randomUser(10);
		boolean success = accService.createAccount(username, "12345password");
		if (!success) {
			throw new Exception("Couldn't make an account.");
		}

		LoginService loginService = new LoginService();

		boolean authorised = loginService.isAuthorised(username, "12345password");
		if (!authorised) {
			throw new Exception("Couldn't login.");
		}

	}

}
