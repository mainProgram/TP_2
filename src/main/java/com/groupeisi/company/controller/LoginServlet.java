package com.groupeisi.company.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.groupeisi.company.dto.UserDto;
import com.groupeisi.company.service.IUserService;
import com.groupeisi.company.service.UserService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet{
	
	private Logger log = LoggerFactory.getLogger(LoginServlet.class);
	private IUserService userService = new UserService();

	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		
		log.info("L'email envoyé est {}", email);
		
		try {
			Optional<UserDto> user = userService.login(email, pwd);
			if (user.isPresent()) {
				req.getSession().setAttribute("username", email);
				resp.sendRedirect("welcome");
			} else {
				resp.sendRedirect("login");
			}
		} catch (Exception e) {
			log.error("Erreur", e);
			resp.sendRedirect("login");
		}
	}
	
}
