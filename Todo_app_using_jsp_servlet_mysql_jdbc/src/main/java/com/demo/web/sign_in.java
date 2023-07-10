package com.demo.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.User;
import com.todo.dao.UserDao;

/**
 * Servlet implementation class sign_in
 */
@WebServlet("/sign_in")
public class sign_in extends HttpServlet {
/*	private static final long serialVersionUID = 1L;
	private User user;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("lname"));
		user.setPassword(request.getParameter("pass"));
		
		try {
			int respond=UserDao.registerUser(user);
			if(respond==1) {
				request.setAttribute("Notification", "User Register Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
		
	}
*/
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private User user;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("sign_in.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		try {
			 userDao.registerUser(user);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
	}
}
