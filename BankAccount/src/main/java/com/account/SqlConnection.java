package com.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class SqlConnection {
    Connection con;

    public void createAccount(int customerID) throws SQLException {
        SqlConnection db  = new SqlConnection();
        String        sql = "INSERT INTO accounts VALUES(?,?,?,?)";

        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, null);
        ps.setInt(2, customerID);
        ps.setDouble(3, 0);
        ps.setInt(4, generateAccountNumber());
        ps.execute();
        con.close();
    }

    public long createCustomer(String firstName, String lastName, String email, String password) throws SQLException {
        SqlConnection db  = new SqlConnection();
        String        sql = "INSERT INTO customer VALUES(?,?,?,?,?)";

        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, null);
        ps.setString(2, firstName);
        ps.setString(3, lastName);
        ps.setString(4, email);
        ps.setString(5, password);

        long result = ps.executeUpdate();

        con.close();

        return result;
    }

    // Creates unique account number for dashboard. Only for aesthetic purposes.
    public int generateAccountNumber() throws SQLException {
        SqlConnection db            = new SqlConnection();
        Random        rand          = new Random();
        int           accountNumber = 100000 + rand.nextInt(900000);

        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM accounts WHERE accountNumber=?");

        ps.setInt(1, accountNumber);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            accountNumber = rand.nextInt();
            ps.setInt(1, accountNumber);
            rs = ps.executeQuery();
        }
        rs.close();
        con.close();

        return accountNumber;
    }

    public Double updateBalance(String email, Double depositAmount) throws SQLException {
        SqlConnection db  = new SqlConnection();
        String        sql =
            "UPDATE accounts, customer SET balance=? WHERE customer.customerID = accounts.customerID AND customer.email=?";
        String sql2 =
            "SELECT balance FROM accounts, customer WHERE accounts.customerID = customer.customerID AND email=?";

        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, depositAmount);
        ps.setString(2, email);
        ps.execute();

        PreparedStatement ps2 = con.prepareStatement(sql2);

        ps2.setString(1, email);

        ResultSet rs = ps2.executeQuery();

        rs.next();

        Double newBalance = rs.getDouble(1);
        con.close();

        return newBalance;
    }

    public boolean verifyLogin(String email, String password) throws SQLException {
        SqlConnection db     = new SqlConnection();
        String        sql    = "SELECT * FROM customer WHERE email=? and password=?";
        boolean       verify = false;

        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            verify = true;
        }

        return verify;
    }

    // Retrieves customer's account data for LoginServlet
    public Account getAccount(int customerID) throws SQLException {
        String sql =
            "SELECT * FROM accounts, customer WHERE customer.customerID=? AND customer.customerID=accounts.customerID";
        SqlConnection db = new SqlConnection();

        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, customerID);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Account account = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4));

            return account;
        }

        con.close();

        return null;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "admin", "password");
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            e.printStackTrace();
        }

        return con;
    }

    // Retrieves customer data for LoginServlet
    public Customer getCustomer(String email) throws SQLException {
        String        sql = "SELECT * FROM customer WHERE email=?";
        SqlConnection db  = new SqlConnection();

        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Customer customer = new Customer(rs.getInt(1),
                                             rs.getString(2),
                                             rs.getString(3),
                                             rs.getString(4),
                                             rs.getString(5));

            return customer;
        }

        con.close();

        return null;
    }
    
    public long insertTransaction(Transaction transaction) throws SQLException {
    	String        sql = "INSERT INTO transactions VALUES(?,?,?,?,?,?)";
        SqlConnection db  = new SqlConnection();
        long result;
        con = db.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, null);
        ps.setInt(2, transaction.getSendingAccountID());
        ps.setInt(3, transaction.getRecipientAccountID());
        ps.setString(4, transaction.getTransactionDate().toString());
        ps.setDouble(5, transaction.getTransactionAmount());
        ps.setString(6, transaction.getTransactionType());
        
        result = ps.executeUpdate();
        con.close();
        return result;
    }
    
    public ArrayList<Transaction> retrieveAllTransactions(int customerID) throws SQLException{
    	String sql = "SELECT * FROM transactions WHERE transactions.recipientAccountID = ? OR transactions.sendingAccountID = ?";
    	SqlConnection db  = new SqlConnection();
        con = db.getConnection();
        ArrayList<Transaction> allTransactionsList = new ArrayList<Transaction>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, customerID);
        ps.setInt(2, customerID);
        ResultSet  rs = ps.executeQuery();
        while(rs.next()) {
        	Transaction transaction = new Transaction(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
        	allTransactionsList.add(transaction);
        }
		return allTransactionsList;
    }
    
    public ArrayList<Transaction> retrieveAllDeposits(int customerID) throws SQLException{
    	String sql = "SELECT * FROM transactions, customer WHERE transactions.recipientAccountID = customer.customerID AND transactions.recipientAccountID = ? AND transactions.transactionType = ?";
    	SqlConnection db  = new SqlConnection();
        con = db.getConnection();
        ArrayList<Transaction> DepositsTransactionsList = new ArrayList<Transaction>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, customerID);
        ps.setString(2, "Deposit");
        ResultSet  rs = ps.executeQuery();
        while(rs.next()) {
        	Transaction transaction = new Transaction(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
        	DepositsTransactionsList.add(transaction);
        }
        ps.close();
        con.close();
        rs.close();
		return DepositsTransactionsList;
    }
    
    public ArrayList<Transaction> retrieveAllTransfers(int customerID) throws SQLException{
    	String sql = "SELECT * FROM transactions, customer WHERE transactions.transactionType = ? AND customer.customerID = ? AND customer.customerID = transactions.sendingAccountID";
    	SqlConnection db  = new SqlConnection();
        con = db.getConnection();
        ArrayList<Transaction> TransfersTransactionsList = new ArrayList<Transaction>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "Transfer");
        ps.setInt(2, customerID);
        
        ResultSet  rs = ps.executeQuery();
        while(rs.next()) {
        	Transaction transaction = new Transaction(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
        	TransfersTransactionsList.add(transaction);
        	System.out.println("tRANSFER AMOUNTS:" + transaction.getTransactionAmount());
        }
        ps.close();
        con.close();
        rs.close();
		return TransfersTransactionsList;
    }
    
}
