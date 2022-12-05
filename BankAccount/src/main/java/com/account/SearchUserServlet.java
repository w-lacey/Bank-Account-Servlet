package com.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TransferServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    ServletContext sc;

    public SearchUserServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String path = "Transfer.jsp";
		SqlConnection db = new SqlConnection();
		Customer customer; 
		con = db.getConnection();
		String searchEmail = request.getParameter("customerSearchEmail");
		try {
			customer = db.getCustomer(searchEmail);
			if(customer!=null) {
				
			}
			else {
				request.setAttribute("error", "");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
