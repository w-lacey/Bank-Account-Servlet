package com.account;

public class Customer {
	final int customerID;
	final String firstName;
	final String lastName;
	final String email;
	final String password;
	
	public Customer(int customerID, String firstName, String lastName, String email, String password) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public int getCustomerID() {
		return customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}


	
	
}
