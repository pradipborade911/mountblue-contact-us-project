package io.mountblue.pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mountblue.dao.ContactUsDao;
import io.mountblue.dao.ContactUsDaoImpl;
import io.mountblue.dao.AdminDao;
import io.mountblue.dao.AdminDaoImpl;
import io.mountblue.pojos.ContactRequest;
import io.mountblue.pojos.Admin;


@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet{
	
	ContactUsDao contactUsDao;
	
	@Override
	public void init() throws ServletException {
		contactUsDao = new ContactUsDaoImpl();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		System.out.println("Full Name: " + fullName + ", Email: " + email + ", Message: " + message);
		
		ContactRequest conatctRequest = new ContactRequest();
		conatctRequest.setFullName(fullName);
		conatctRequest.setEmail(email);
		conatctRequest.setMessage(message);
		
		boolean isSubmitSuccess = contactUsDao.createContactUsRequest(conatctRequest);
		
		if(isSubmitSuccess) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			req.setAttribute("isSubmitSuccess", true);
			rd.forward(req, resp);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
//		resp.sendRedirect("/login.jsp");
	}

}
