package br.com.dup.pweb.sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.pweb.carrinho.model.Carrinho;
import br.edu.ifpb.pweb.carrinho.model.Catalogo;

/**
 * Servlet implementation class ResumoSevlet
 */
@WebServlet("/comprar")
public class ResumoSevlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text-html");
		
		HttpSession session = request.getSession();		
		request.setAttribute("itens", session.getAttribute("carrinho"));
		
		RequestDispatcher rs = request.getRequestDispatcher("comprar.jsp");
		rs.forward(request, response);		
	}

}
