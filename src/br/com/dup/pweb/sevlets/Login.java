package br.com.dup.pweb.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String names = "joe";
	private String pass = "123";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
				
		if((request.getParameter("name").equals(names)) && (request.getParameter("pass").equals(pass))){
			HttpSession session = request.getSession();
			session.setAttribute("name", this.names);
			session.setMaxInactiveInterval(20*100);
			
			response.sendRedirect("index.jsp");
		}else{
			request.setAttribute("error", "Senha ou login invalido");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
			
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
		
	}
}
