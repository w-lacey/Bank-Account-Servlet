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

@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    SqlConnection             db               = new SqlConnection();
    Connection                con;
    ServletContext            sc;

    public CreateAccountServlet() {
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

        String path;
        String error = "account creation failed!! Please try again!!";

        sc  = getServletContext();
        con = db.getConnection();

        String firstName = request.getParameter("firstNameInput");
        String lastName  = request.getParameter("lastNameInput");
        String email     = request.getParameter("emailInput");
        String password  = request.getParameter("passwordInput");

        try {
            long result = db.createCustomer(firstName, lastName, email, password);

            System.out.println(result);

            if (result == 1) {
                Customer customer = db.getCustomer(email);

                db.createAccount(customer.getCustomerID());
                path = "/index.jsp";
            } else {
                path = "/CreateAccount.jsp";
                request.setAttribute("error", error);
            }

            System.out.println(path);

            RequestDispatcher rd = sc.getRequestDispatcher(path);

            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
