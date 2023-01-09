package com.account;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ServletContext            sc;
    Connection                con;

    public TransferServlet() {
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

        String      path = "Profile/Transfer.jsp";
        HttpSession hs   = request.getSession();

        sc = getServletContext();

        Account       account        = (Account) hs.getAttribute("account");
        Customer      customer       = (Customer) hs.getAttribute("customer");
        String        transferEmail  = hs.getAttribute("returnedEmail").toString();
        SqlConnection db             = new SqlConnection();
        Double        transferAmount = Double.valueOf(request.getParameter("transferAmount"));
        try {
            if (transferAmount <= account.getBalance()) {
                path = "/Profile/Profile.jsp";

                Double newBalance = account.getBalance() - transferAmount;

                System.out.println(newBalance);
                db.updateBalance(customer.getEmail(), newBalance);
                db.updateBalance(transferEmail, transferAmount);
                account.setBalance(newBalance);
                hs.setAttribute("account", account);
                Transaction transaction = new Transaction(account.getAccountID(), account.getAccountID(), LocalDateTime.now().toString(), transferAmount, "Transfer");
                db.insertTransaction(transaction);
            } else {
                request.setAttribute("error", "The entered amount exceeds your balance!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = sc.getRequestDispatcher(path);

        rd.forward(request, response);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
