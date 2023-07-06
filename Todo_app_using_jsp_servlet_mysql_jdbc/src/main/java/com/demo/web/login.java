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


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		authenticate(request, response);
	}


	private void authenticate(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("lname");
		String password=request.getParameter("lpass");
		Login_User luser= new Login_User();
		luser.setEmail(username);
		luser.setPassword(password);
		try {
		if(ldao.validuser(luser))
		{
			System.out.println("User is valid!");
			RequestDispatcher rd = request.getRequestDispatcher("todo-list.jsp"); 
		}else {
			HttpSession session = request.getSession();
            session.setAttribute("lname", username);
            response.sendRedirect("index.jsp");
			}
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
