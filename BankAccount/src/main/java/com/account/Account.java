package com.account;

public class Account {
	
	Customer customer;
	final int accountID;
	final int customerID;
	double balance;
	final int accountNumber;
	
	public Account(int accountID, int customerID, double balance, int accountNumber) {
		
		this.accountID = accountID;
		this.customerID = customerID;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getAccountID() {
		return accountID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
}
