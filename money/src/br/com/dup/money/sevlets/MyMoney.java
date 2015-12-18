package br.com.dup.money.sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dup.money.CountMoney;

/**
 * Servlet implementation class MyMoney
 */
@WebServlet("/money")
public class MyMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int val;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("valor") == null || request.getParameter("valor").equals(""))
			response.sendError(500, "Não foi informado um valor valído");
		
		val = Integer.parseInt(request.getParameter("valor"));
		
		CountMoney m = new CountMoney(val);
		request.setAttribute("reports", m.getReports());
		
		
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);
		
	}

}
