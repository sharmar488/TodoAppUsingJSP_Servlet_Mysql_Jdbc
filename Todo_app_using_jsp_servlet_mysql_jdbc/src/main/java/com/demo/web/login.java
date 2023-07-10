package com.demo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.Login_User;
import com.todo.dao.LoginDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao ldao; 
    
	@Override
	public void init() throws ServletException {
		ldao=new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		authenticate(request, response);
	}


	private void authenticate(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Login_User luser= new Login_User();
		luser.setEmail(username);
		luser.setPassword(password);
		try {
		if(ldao.validuser(luser))
		{
			System.out.println("User is valid!");
			request.getSession().setAttribute("username", username);
			RequestDispatcher dispatcher=request.getRequestDispatcher("todos-list.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("invalidUser", true);
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			}
		}catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
