package br.edu.ifpb.calendarwars.sevlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.calendarwars.db.GenericDAOQuerys;
import br.edu.ifpb.calendarwars.db.UserDAO;
import br.edu.ifpb.calendarwars.entities.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try{					
			UserDAO userdao = new UserDAO((EntityManager) request.getAttribute("instanceDB"));			
			User user = userdao.auth(request.getParameter("login"), request.getParameter("pass"));
				
			System.out.println(user.getName());
			
			if(user != null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(20*100);
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("error", "Usuario ou senha incorretas");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){			
			request.setAttribute("error", "Banco de dados vazio ou fora do ar");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}			
	}

}
