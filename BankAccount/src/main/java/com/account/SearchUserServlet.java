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

@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection                con;
    ServletContext            sc;

    public SearchUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

        HttpSession hs   = request.getSession();
        String      path = "/Transfer.jsp";

        sc = getServletContext();

        SqlConnection db = new SqlConnection();
        Customer      customer;

        con = db.getConnection();

        String searchEmail = request.getParameter("customerSearchEmail");

        try {
            customer = db.getCustomer(searchEmail);

            if (customer == null) {
                path = "/SearchUser.jsp";
                request.setAttribute("error", "User not found! Try again");
            } else {
                hs.setAttribute("returnedEmail", searchEmail);
            }

            RequestDispatcher rd = sc.getRequestDispatcher(path);;

            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
