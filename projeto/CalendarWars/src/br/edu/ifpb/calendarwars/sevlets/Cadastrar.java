package br.edu.ifpb.calendarwars.sevlets;

import java.io.IOException;

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
 * Servlet implementation class Cadastrar
 */
@WebServlet("/cadastro")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rt = request.getRequestDispatcher("cadastro.jsp");
		rt.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(!request.getParameter("name").isEmpty() && !request.getParameter("login").isEmpty() && !request.getParameter("pass").isEmpty()){
				System.out.println("owier foi");
				User user = new User();	
				UserDAO userdao = new UserDAO();					
				
				user.setName(request.getParameter("name"));
				user.setUser(request.getParameter("login"));
				user.setPass(request.getParameter("pass"));
				
				userdao.insert(user);
				
				//HttpSession session = request.getSession();
				//session.setAttribute("name", request.getParameter("name"));
				//session.setMaxInactiveInterval(20*100);
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			e.getStackTrace();	
		}
	}

}
