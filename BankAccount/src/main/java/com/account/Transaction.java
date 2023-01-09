package com.account;

import java.util.Date;

public class Transaction {

	public int transactionID;
	private int sendingAccountID;
	private int recipientAccountID;
	private String  transactionDate;
	private double transactionAmount;
	private String transactionType;
	
	public Transaction(int sendingAccountID, int recipientAccountID, String transactionDate,
			double transactionAmount, String transactionType) {
		this.sendingAccountID = sendingAccountID;
		this.recipientAccountID = recipientAccountID;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}


	public int getSendingAccountID() {
		return sendingAccountID;
	}

	public void setSendingAccountID(int sendingAccountID) {
		this.sendingAccountID = sendingAccountID;
	}

	public int getRecipientAccountID() {
		return recipientAccountID;
	}

	public void setRecipientAccountID(int recipientAccountID) {
		this.recipientAccountID = recipientAccountID;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
