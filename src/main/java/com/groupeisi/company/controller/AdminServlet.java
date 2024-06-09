package com.groupeisi.company.controller;
import com.groupeisi.company.dto.UserDto;
import com.groupeisi.company.service.IUserService;
import com.groupeisi.company.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name="admin", value="/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("userList", userService.getAll());

		request.getRequestDispatcher("WEB-INF/jsp/admin/users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDto userDto = new UserDto(0, firstName, lastName, email, password);
		
		userService.save(userDto);
		
		doGet(req, resp);
	}

}
