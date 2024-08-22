package io.mountblue.pages;

import java.io.IOException;

import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.mountblue.dao.AdminDao;
import io.mountblue.dao.AdminDaoImpl;
import io.mountblue.pojos.Admin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	AdminDao admin;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inside init");
		admin =  new AdminDaoImpl();
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("Username: " + username + ", password: " + password);
		Admin user = admin.authenticateAdmin(username, password);
		
		if(user == null) {
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}		
		
		HttpSession session = req.getSession(true);
		session.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("showrequests");
		rd.forward(req, resp);
		System.out.println(user);
	}
	
}
