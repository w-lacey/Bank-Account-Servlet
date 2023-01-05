package com.account;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection                con;
    ServletContext            sc;
    Transaction transaction;
    public DepositServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        sc = getServletContext();
        
        SqlConnection db = new SqlConnection();
        con = db.getConnection();

        HttpSession session       = request.getSession();
        Account     account       = (Account) session.getAttribute("account");
        Customer    customer      = (Customer) session.getAttribute("customer");
        double      depositAmount = Double.parseDouble(request.getParameter("depositAmount"));

        try {
            Double newBalance = db.updateBalance(customer.getEmail(), depositAmount + account.getBalance());
            account.setBalance(newBalance);
            session.setAttribute("account", account);
            transaction = new Transaction(account.getAccountID(), account.getAccountID(), LocalDateTime.now().toString(), depositAmount, "Deposit");
            db.insertTransaction(transaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = sc.getRequestDispatcher("/Profile.jsp");

        rd.forward(request, response);
    }
}
