package br.edu.ifpb.calendarwars.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.calendarwars.db.CoreDB;

/**
 * Servlet Filter implementation class Filterdb
 */
@WebFilter(urlPatterns={"*.jsp", "/cadastro", "/login", "/date"})
public class Filterdb implements Filter {

   public void destroy() {
	   CoreDB.InstanceNull();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();		
		session.setAttribute("instanceDB", CoreDB.Instance());
		chain.doFilter(request, response);		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
