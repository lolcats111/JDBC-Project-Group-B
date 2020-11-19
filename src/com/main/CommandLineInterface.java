package com.main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.bean.*;
import com.service.*;

public class CommandLineInterface {

	static final int lineLength = 40;
	static final int screenHeight = 20;
	static final int indent = 5;

	static final int loginOption = 1;
	static final int createAccountOption = 2;
	static final int homeQuitOption = 3;

	static final int noOption = 0;
	static final int addCustomerOption = 1;
	static final int listCustomersOption = 2;
	static final int viewCustomerOption = 3;
	static final int editCustomerOption = 4;
	static final int deleteCustomerOption = 5;
	static final int openAccountOption = 6;
	static final int closeAccountOption = 7;
	static final int depositAmountOption = 8;
	static final int withdrawAmountOption = 9;
	static final int viewTransactionsOption = 10;
	static final int addClerkAccountOption = 11;
	static final int quitOption = 12;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean running = true;
		boolean loggedIn = false;
		String output = "";
		int option = 0;

		Scanner sc = new Scanner(System.in);

		// Main command loop.
		while (running) {

			System.out.println(header("ABC Bank System", '-'));

			if (!loggedIn) {

				switch (option) {
				case loginOption:
					if (runLogin()) {
						loggedIn = true;
					} else {
						System.out.println("Invalid Credentials.");
					}
					option = noOption;
					break;
				case createAccountOption:
					if (!makeAccount()) {
						System.out.println("Failed to make account.");
						option = createAccountOption;
					} else {
						option = noOption;
					}
					break;
				case homeQuitOption:
					System.exit(1);
				default:
					option = accountOptionSelect();
				}

			} else if (output.equals("")) {

				if (option == noOption) {
					option = runOptionSelect();
				} else if (option == quitOption) {
					running = false;
				} else {
					output = optionHandler(option);
					option = noOption;
				}
			} else {
				System.out.println();
				System.out.println(output);
				System.out.println(header("Press ENTER to continue."));
				sc.nextLine();
				output = "";
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

	static boolean makeAccount() {

		boolean succeeded = false;
		Scanner sc = new Scanner(System.in);

		System.out.println(header("Create Clerk Account"));

		System.out.print(field("Username", 15));
		String username = sc.nextLine();

		System.out.print(field("Password", 15));
		String password = sc.nextLine();

		CreateAccountService cas = new CreateAccountService();

		try {
			succeeded = cas.createAccount(username, password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return succeeded;
	}

	static int accountOptionSelect() {

		int option = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println(header("Welcome Clerk."));

		System.out.println(option(loginOption, "Login"));
		System.out.println(option(createAccountOption, "Make Account"));

		System.out.println(option(homeQuitOption, "Quit"));

		System.out.println();
		System.out.print(field("Select your option", 15));
		option = sc.nextInt();

		return option;

	}

	static int runOptionSelect() {

		int option = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println(header("Welcome Clerk."));

		System.out.println(option(addCustomerOption, "Add Customer"));
		System.out.println(option(listCustomersOption, "List Customers"));
		System.out.println(option(viewCustomerOption, "View Customer"));
		System.out.println(option(editCustomerOption, "Edit Customer"));
		System.out.println(option(deleteCustomerOption, "Delete Customer"));
		System.out.println(option(openAccountOption, "Open Account"));
		System.out.println(option(closeAccountOption, "Close Account"));
		System.out.println(option(depositAmountOption, "Deposit Amount"));
		System.out.println(option(withdrawAmountOption, "Withdraw Amount"));
		System.out.println(option(viewTransactionsOption, "View Trasactions"));
		System.out.println(option(addClerkAccountOption, "Add Clerk Account"));
		System.out.println(option(quitOption, "Quit"));

		System.out.println();
		System.out.print(field("Select your option", 15));
		option = sc.nextInt();

		return option;

	}

	static String optionHandler(int option) {

		String output = "";

		switch (option) {
		case addCustomerOption:
			output = runAddCustomer();
			break;
		case listCustomersOption:
			output = runListCustomers();
			break;
		}

		return output;

	}

	static String runAddCustomer() {

		Scanner sc = new Scanner(System.in);

		System.out.println(header("Customer Registration"));

		System.out.print(field("Name", 15));
		String name = sc.nextLine();
		System.out.print(field("Gender", 15));
		char gender = sc.nextLine().charAt(0);
		System.out.print(field("Email", 15));
		String email = sc.nextLine();
		System.out.print(field("Phone", 15));
		String phone = sc.nextLine();
		System.out.print(field("Address", 15));
		String address = sc.nextLine();
		System.out.print(field("Privileged", 15));
		String isPrivileged = sc.nextLine();

		CustomerService cs = new CustomerService();
		Customer customer = new Customer(name, gender, email, phone, address, isPrivileged);

		return display(cs.addCustomer(customer));
	}

	static String runListCustomers() {

		String output = "";

		CustomerService cs = new CustomerService();

		Customer[] customers = cs.listCustomers();

		for (Customer customer : customers) {
			output += (display(customer) + "\n\n");
		}

		return output;

	}

	static String display(Customer customer) {

		return field("Id", 15) + customer.getId() + "\n" + field("Name", 15) + customer.getName() + "\n"
				+ field("Gender", 15) + customer.getGender() + "\n" + field("Email", 15) + customer.getEmail() + "\n"
				+ field("Phone", 15) + customer.getPhone() + "\n" + field("Address", 15) + customer.getAddress() + "\n"
				+ field("Privileged", 15) + customer.getIsPrivileged();
	}

	static String display(BankAccount account) {
		return "";
	}

	static String header(String text) {
		return ("\n" + center(text) + "\n");
	}

	static String header(String text, char symbol) {
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

	static String field(String text, int width) {
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
