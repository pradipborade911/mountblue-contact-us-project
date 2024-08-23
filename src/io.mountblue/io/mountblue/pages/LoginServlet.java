package io.mountblue.pages;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.mountblue.dao.UserDao;
import io.mountblue.dao.UserDaoImpl;
import io.mountblue.pojos.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	UserDao admin;
	
	@Override
	public void init() throws ServletException {
		admin =  new UserDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("user")!=null){
			resp.sendRedirect("dashboard");
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = admin.authenticateUser(username, password);
		
		if(user == null) {
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("wrongCreds", "true");
			rd.forward(req, resp);
			return;
		}		
		
		HttpSession session = req.getSession(true);
		session.setAttribute("user", user);
		resp.sendRedirect("dashboard");
	}
	
}
