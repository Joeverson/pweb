package br.com.dup.lostlabirinty.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dup.lostlabirinty.dao.DAO;
import br.com.dup.lostlabirinty.dao.DAOWarrior;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private DAOWarrior daowarrior = new DAOWarrior();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		response.setStatus(200);

		PrintWriter out = response.getWriter();
		out.println(request.getParameter("s"));
		
		//DAO.begin();
		//System.out.println(daowarrior.findMyWarrior(request.getParameter("s").toString()));
		//DAO.commit();
	}

}
