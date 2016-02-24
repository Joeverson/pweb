package br.edu.ifpb.tsi.pweb.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.tsi.pweb.dao.HolydaysDAO;
import br.edu.ifpb.tsi.pweb.dao.PersistenceUtil;
import br.edu.ifpb.tsi.pweb.model.Holydays;
import br.edu.ifpb.tsi.pweb.model.User;


/**
 * Servlet implementation class Calendar
 */
@WebServlet("/calendar")
public class Calendars extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher r;
		
		if(session.getAttribute("user") == null)
			r = request.getRequestDispatcher("login.jsp");
		else
			r = request.getRequestDispatcher("calendar.jsp");
		
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");	
		String[] dateArray = date.split("-");
		
		//preparando o objedo calendar com a data recebida.
		Calendar c = Calendar.getInstance();
		c.set(Integer.valueOf(dateArray[0]), Integer.valueOf(dateArray[1]), Integer.valueOf(dateArray[2]));
		
		//pegando as outras informações
		String note = request.getParameter("note");
		String type = request.getParameter("type");
				
				
		HttpSession session = request.getSession();
		
		if(((User) session.getAttribute("user")) == null){
			request.setAttribute("error", "ERRO: ao gravar a nota");
			
		}else{			
			Holydays h = new Holydays(type,note,c);
			//CalendarDAO DAO = new CalendarDAO(PersistenceUtil.getCurrentEntityManager());
			//DAO.insert(h);
		}
		
		
		RequestDispatcher r = request.getRequestDispatcher("admin.jsp");
		r.forward(request, response);
	}
}
