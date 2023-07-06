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
	private static final long serialVersionUID = 1L;
	private User user;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
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

}
