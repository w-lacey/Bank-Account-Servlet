package com.account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/TransferTransactionListServlet")
public class TransferTransactionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SqlConnection db = new SqlConnection();
    ServletContext  sc;
    String path = "/Profile/AllTransactionsList.jsp";
    ArrayList<Transaction> TransferTransactionsList;
   
    public TransferTransactionListServlet() {
        super();
    }

    //
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		sc = getServletContext();
		Customer customer = (Customer) session.getAttribute("customer");
		try {
			TransferTransactionsList = db.retrieveAllTransfers(customer.getCustomerID());
            request.setAttribute("transactionList",TransferTransactionsList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = sc.getRequestDispatcher(path);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
