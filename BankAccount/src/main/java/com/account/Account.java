package com.account;

import java.math.BigDecimal;

public class Account {
    Customer  customer;
    final int accountID;
    final int customerID;
    Double    balance;
    final int accountNumber;

    public Account(int accountID, int customerID, double balance, int accountNumber) {
        this.accountID     = accountID;
        this.customerID    = customerID;
        this.balance       = balance;
        this.accountNumber = accountNumber;
    }

    public int getAccountID() {
        return accountID;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double newBalance) {
        this.balance = newBalance;
    }

    public int getCustomerID() {
        return customerID;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
