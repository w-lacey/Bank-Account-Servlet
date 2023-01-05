package com.account;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    SqlConnection             db               = new SqlConnection();
    ServletContext            sc;
    Connection                con;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        sc  = getServletContext();
        con = db.getConnection();

        String path;
        String email    = request.getParameter("emailInput");
        String password = request.getParameter("passwordInput");

        try {
            boolean verify = db.verifyLogin(email, password);

            if (verify) {
                Customer    customer = db.getCustomer(email);
                Account     account  = db.getAccount(customer.getCustomerID());
                HttpSession hs       = request.getSession();

                hs.setAttribute("customer", customer);
                hs.setAttribute("account", account);
                path = "/Profile.jsp";
            } else {
                path = "/index.jsp";
                request.setAttribute("error", "invalid login!! Please try again");
            }

            System.out.println("path value: " + path);

            RequestDispatcher rd = sc.getRequestDispatcher(path);

            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


