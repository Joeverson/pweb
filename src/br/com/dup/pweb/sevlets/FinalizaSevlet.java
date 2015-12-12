package br.com.dup.pweb.sevlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.pweb.carrinho.model.Item;
import br.edu.ifpb.pweb.carrinho.model.ItemCarrinho;

@WebServlet("/finalizar")
public class FinalizaSevlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		List<ItemCarrinho> c = (List<ItemCarrinho>) session.getAttribute("carrinho");


		String str = "+-- Produtos Comprados / ID "+new Date().hashCode()+" --+\n\n";
		str += "+-- itens: --+\n";		
		for(ItemCarrinho i: c){
			str += "ID: "+i.getItemID()+ " - Descricao: "+i.getDescricaoCurta()+ " - Preço: "+i.getPrecoUnitario()+"\n";
		}		
		str +="+-------------+\n"; 



		FileWriter arquivo;  

		try {  
			arquivo = new FileWriter(new File(this.toString()+"log.txt"));  
			arquivo.write(str);  
			arquivo.close();  
		} catch (IOException e) {  
			e.printStackTrace();  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  



		session.invalidate();
		response.sendRedirect("index.jsp");
	}
}
