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
import br.edu.ifpb.pweb.carrinho.model.Item;

@WebServlet("/pedido")
public class PedidoSevlet extends HttpServlet {
	private Carrinho carrinho = new Carrinho(); 
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("carrinho", carrinho.getItemsCarrinho());
		
		
		request.setAttribute("itens", session.getAttribute("carrinho"));
		
		RequestDispatcher rs = request.getRequestDispatcher("pedido.jsp");
		rs.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setStatus(200);
		
		//adicionnado ao carrinho
		this.carrinho.adicioneItem(request.getParameter("id"));
	}

}
