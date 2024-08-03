package com.groupeisi.company.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class PrivateFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession	session = req.getSession();
		
		//On recup le nom de la session
		String username = (String) session.getAttribute("username");
		
		//On recup le chemin demandé par l'utilisateur
		String chemin = req.getServletPath();
		
		//On recup la methode HTTP utilisée get ou post
		String method = req.getMethod();
		if(username != null || chemin.equals("/") || chemin.equals("/login") || chemin.equals("signup")
				|| chemin.equals("logout") || chemin.equals("index.jsp") || chemin.equals("/login") && method.equalsIgnoreCase("POST")  
				|| chemin.equals("/signup") && method.equalsIgnoreCase("POST") || chemin.equals("/public")) 
		{
			chain.doFilter(request, response);
		}
		else 
		{
			resp.sendRedirect("login");
		}
		
		
	}
	
	

}
