package com.account;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class SqlConnection {
	Connection con;
	public Connection getConnection() {
		try{  
			  Class.forName("com.mysql.cj.jdbc.Driver");  
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "andrew", "password");   
			  System.out.println ("Database connection established");  
		}catch (Exception e){  
			  System.err.println ("Cannot connect to database server");  
			  }
		return con;
	}
	public Double updateBalance(int accountID, Double amount) throws SQLException {
		SqlConnection db = new SqlConnection();
		String sql = "SELECT balance FROM accounts WHERE accountID=?";
		String sql2 = "UPDATE accounts SET balance=? WHERE accountID=?";
		Double newBalance = 0.0;
		con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,accountID);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Double oldBalance = Double.valueOf(rs.getString(1));
			newBalance = oldBalance + Double.valueOf(amount);
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setDouble(1,newBalance);
			ps2.setInt(2, accountID);
			ps2.execute();
		}
		con.close();
		return newBalance;
	}
	public void createAccount(int customerID) throws SQLException {
		SqlConnection db = new SqlConnection();
		String sql = "INSERT INTO accounts VALUES(?,?,?,?)";
		con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,null);
		ps.setInt(2, customerID);
		ps.setFloat(3,0);
		ps.setInt(4, generateAccountNumber());
		ps.execute();
		con.close();
	}
	public long createCustomer(String firstName, String lastName, String email, String password) throws SQLException {
		SqlConnection db = new SqlConnection();
		String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
		con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,null);
		ps.setString(2,firstName);
		ps.setString(3,lastName);
		ps.setString(4,email);
		ps.setString(5, password);
		long result = ps.executeUpdate();
		con.close();
		return result;
	}
	public int generateAccountNumber() throws SQLException {
		SqlConnection db = new SqlConnection();
		Random rand = new Random();
		int accountNumber = 100000 + rand.nextInt(900000);
		con = db.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM accounts WHERE accountNumber=?");
		ps.setInt(1, accountNumber);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			accountNumber = rand.nextInt();
			ps.setInt(1, accountNumber);
			rs = ps.executeQuery();
		}
		con.close();	
		return accountNumber;
	}
	
	public boolean verifyLogin(String email, String password) throws SQLException {
		SqlConnection db = new SqlConnection();
		String sql = "SELECT * FROM customer WHERE email=? and password=?";
		boolean verify = false;
		con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	verify = true;
        }
        return verify;
	}
	
	//Retrieves customer data for LoginServlet
	public Customer getCustomer(String email) throws SQLException {
		String sql = "SELECT * FROM customer WHERE email=?";
		SqlConnection db = new SqlConnection();
		con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,email);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			return customer;
		}
		con.close();
		return null;
		
	}
	//Retrieves customer's account data for LoginServlet
	public Account getAccount(int customerID) throws SQLException {
		String sql = "SELECT * FROM accounts, customer WHERE customer.customerID=? AND customer.customerID=accounts.customerID";
		SqlConnection db = new SqlConnection();
		con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,customerID);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Account account = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4));
			return account;
		}
		con.close();
		return null;
	}

}
