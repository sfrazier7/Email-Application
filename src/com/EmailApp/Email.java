package com.EmailApp;

import java.util.Scanner;

public class Email {
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPassLength = 10;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "natpaladins.com";
	
	//Constructor
	//first name & last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	
	//method asking for a department - returns department
		this.department = setDepartment();
	
	// Call a method to return a random password
		this.password = randPassword(defaultPassLength);
		System.out.println("Your password is: " + this.password);
		
	//Combines elements to make email
	email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" 
			+ department +"."+ companySuffix;
	}
	
	//Ask for department
	private String setDepartment() {
		System.out.println("New worker: " + firstName + ". \nDepartments\n 1 for Sales"
				+ "\n 2 for Development\n 3 for Accounting"
				+ "\n 0 for none \nEnter department code:");
		Scanner input = new Scanner(System.in);
		int depChoice = input.nextInt();
		if(depChoice == 1) { 
			return "sales";
		} else if(depChoice == 2) { 
			return "dev";
		} else if(depChoice == 3) {
			return "acct";
		} else return "";
	}
	
	//Generate a random password
	private String randPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&";
		char[] password = new char[length];
		for(int i = 0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	//Change the password
	public void changePass(String password) {
		this.password = password;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "\nNAME: " + firstName + " " + lastName 
				+ "\nCompany Email: " + email + "\nMailbox Capacity: " 
				+ mailboxCapacity + "mb";
	}
	
}
