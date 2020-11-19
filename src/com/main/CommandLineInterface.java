package com.main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.service.CreateAccountService;
import com.service.LoginService;

public class CommandLineInterface {
	
	static int lineLength = 40;
	static int screenHeight = 20;
	static int indent = 5;
	
	static int noOption = 0;
	static int quitOption = 11;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean running = true;
		boolean loggedIn = false;
		int option = 0;
		
		
		
		// Main command loop.
		while(running) {
			
			System.out.println(header("ABC Bank System", '-'));
			
			if (!loggedIn) {
				
				loggedIn = runLogin();
				
			} else {
				
				if (option == noOption) {
					option = runOptionSelect();
				} else if (option == quitOption) {
					running = false;
				} else {
					
					// Option handler goes here.
					System.out.println(option);
					break;
				}
				
				
			}
			
			System.out.println(clearScreen());
		}
	}
	
	static boolean runLogin() {
		
		boolean loggedIn = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(header("Login"));
		
		System.out.print(field("Username", 15));
		String username = sc.nextLine();
		
		System.out.print(field("Password", 15));
		String password = sc.nextLine();
		
		LoginService loginService = new LoginService();
		
		try {
			 loggedIn = loginService.isAuthorised(username, password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return loggedIn;
	}
	
	static int runOptionSelect() {
		
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(header("Welcome User."));
		
		System.out.println(option(1, "Add Customer"));
		System.out.println(option(2, "List Customers"));
		System.out.println(option(3, "View Customer"));
		System.out.println(option(4, "Edit Customer"));
		System.out.println(option(5, "Delete Customer"));
		System.out.println(option(6, "Open Account"));
		System.out.println(option(7, "Close Account"));
		System.out.println(option(8, "Deposit Amount"));
		System.out.println(option(9, "Withdraw Amount"));
		System.out.println(option(10, "View Trasactions"));
		System.out.println(option(11, "Quit"));
		
		System.out.println();
		System.out.print(field("Select your option", 15));
		option = sc.nextInt();
		
		return option;
		
	}
	
	static String header (String text) {
		return ("\n" + center(text) + "\n");
	}
	
	static String header (String text, char symbol) {
		String seperator = new String(new char[lineLength]).replace('\0', symbol);
		return (seperator + "\n" + center(text) + "\n" + seperator);
	}
	
	static String option(int number, String text) {
		int leftPadding = (indent);
		
		String dotPoint = "[" + number + "]";
		String option = String.format("%" + leftPadding + "s", dotPoint);
		option = String.format("%-5s", option);
		return option + " " + text;
		
	}
	
	static String field (String text, int width) {
		int leftPadding = (text.length() + indent);
		text = String.format("%" + leftPadding + "s", text);
		text = String.format("%-" + width + "s", text);		
		return text + ": ";
	}
	
	static String clearScreen() {
		return new String(new char[screenHeight]).replace('\0', '\n');
	}
	
	
	static String center(String str) {
		int padding = (str.length() + (lineLength - str.length()) / 2);
		str = String.format("%" + padding + "s", str);
		return String.format("%-" + lineLength + "s", str);
	}

}
