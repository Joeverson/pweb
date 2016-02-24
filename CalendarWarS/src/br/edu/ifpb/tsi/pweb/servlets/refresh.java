package br.edu.ifpb.tsi.pweb.servlets;



import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import antlr.collections.List;
import br.edu.ifpb.tsi.pweb.model.CalendarWars;
import br.edu.ifpb.tsi.pweb.model.Holydays;

/**
 * Servlet implementation class Index
 */
@WebServlet("/refresh")
public class refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String date = "2016-02-23";	
		String date = request.getParameter("date");	
		System.out.println(date);
		if(date == ""){
			request.setAttribute("error", "Defina uma Data, para pode visualizar o calendario");
			
			RequestDispatcher r = request.getRequestDispatcher("index.jsp");
			r.forward(request, response);
		}
		
		
		String[] dateArray = date.split("-");
		
		//preparando o objedo calendar com a data recebida.
		Calendar c = Calendar.getInstance();
		c.set(Integer.valueOf(dateArray[0]), Integer.valueOf(dateArray[1]), Integer.valueOf(dateArray[2]));
		 
		Map mounth = new HashMap<String, CalendarWars>();
		
		//cria o calendario dea acordo com o mes escolhido
		for(int i=0; i < c.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
			mounth.put(String.valueOf((i+1)), new Holydays());			
		}
		
		
		
		
		
		//          este bloco é só para testes sem db 
		//              mas o db deve ficar aqui
		//--------------------------------------------------
		//adicionando o mes do banco no hash
		Calendar dateNew = Calendar.getInstance();
		dateNew.set(2016,Calendar.FEBRUARY,22);
		
		Calendar dateNew3 = Calendar.getInstance();
		dateNew3.set(2016,Calendar.FEBRUARY,24);
		
				
		Holydays h2 = new Holydays("substituto","feriado de fresco subistituto", dateNew3);
		
		Holydays h = new Holydays("fixo","casa da veia", dateNew);
		h.setSubstituto(h2);
		
		Calendar dateNew2 = Calendar.getInstance();
		dateNew2.set(2016,Calendar.JANUARY,28);
		Holydays h3 = new Holydays("movel","sou movel e unico", dateNew2);
		
		//Criando a lista com os calendarios a serem colocados no mes corrente escolhido
				ArrayList<CalendarWars> clw = new ArrayList<CalendarWars>();
				clw.add(h3);
				clw.add(h2);
				clw.add(h);
		//--------------------------------------------------
		
				
				
				
		///colocando as datas no calendario recem gerado
		for (CalendarWars cl: clw){			
			if(((Holydays)cl).getType().equals("fixo")){
				if(Integer.valueOf(dateArray[1]) == (cl.getDate().get(Calendar.MONTH) + 1)){
					if(((Holydays)cl).getSubstituto() == null){					
						mounth.put(String.valueOf(cl.getDate().get(Calendar.DAY_OF_MONTH)), cl);
					}else{ //verificando se é do mesmo ano e mes
						if(Integer.valueOf(dateArray[0]) == ((Holydays)cl).getSubstituto().getDate().get(Calendar.YEAR)){
							if(Integer.valueOf(dateArray[1]) == (((Holydays)cl).getSubstituto().getDate().get(Calendar.MONTH) + 1)){
								mounth.put(String.valueOf(((Holydays)cl).getSubstituto().getDate().get(Calendar.DAY_OF_MONTH)), ((Holydays)cl).getSubstituto());
							}
						}
					}
				} 				
			}else if(((Holydays)cl).getType().equals("movel")){ //verificando se é do mesmo ano e mes
				if(Integer.valueOf(dateArray[0]) == cl.getDate().get(Calendar.YEAR)){
					if(Integer.valueOf(dateArray[1]) == (cl.getDate().get(Calendar.MONTH) + 1)){
						mounth.put(String.valueOf(cl.getDate().get(Calendar.DAY_OF_MONTH)), cl);
					}
				}				
			}
		}
		
		request.setAttribute("calendar", mounth);
		
		RequestDispatcher r = request.getRequestDispatcher("index.jsp");
		r.forward(request, response);
	}

}
