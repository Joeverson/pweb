package br.edu.ifpb.calendarwars.sevlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.calendarwars.db.CalendarNotesDAO;
import br.edu.ifpb.calendarwars.entities.CalendarNote;
import br.edu.ifpb.calendarwars.entities.User;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher r;
		
		if(session.getAttribute("user") == null)
			r = request.getRequestDispatcher("login.jsp");
		else
			r = request.getRequestDispatcher("admin.jsp");
		
		r.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		String note = request.getParameter("note");
		
				
		HttpSession session = request.getSession();
		
		if(((User) session.getAttribute("user")) == null){
			
			request.setAttribute("error", "ERRO: ao gravar a nota");
			
		}else{
			CalendarNote notas = new CalendarNote(date, note, type, ((User) session.getAttribute("user")));			
			CalendarNotesDAO dao = new CalendarNotesDAO((EntityManager) session.getAttribute("instanceDB"));
			
			dao.insert(notas);
			
			request.setAttribute("notes", dao.getAll());
		}
		
		
		RequestDispatcher r = request.getRequestDispatcher("admin.jsp");
		r.forward(request, response);
		
	}
}
