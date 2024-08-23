package io.mountblue.pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mountblue.dao.RequestsDao;
import io.mountblue.dao.RequestsDaoImpl;
import io.mountblue.dao.UserDao;
import io.mountblue.dao.UserDaoImpl;
import io.mountblue.pojos.Request;
import io.mountblue.pojos.User;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

	RequestsDao contactUsDao;

	@Override
	public void init() throws ServletException {
		contactUsDao = new RequestsDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("contactus.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String message = req.getParameter("message");

		Request conatctRequest = new Request();
		conatctRequest.setFullName(fullName);
		conatctRequest.setEmail(email);
		conatctRequest.setMessage(message);

		boolean isSubmitSuccess = contactUsDao.saveRequest(conatctRequest);

		if (isSubmitSuccess) {
			RequestDispatcher rd = req.getRequestDispatcher("contactus.jsp");
			req.setAttribute("isSubmitSuccess", true);
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("contactus.jsp");
			rd.forward(req, resp);
		}
	}

}
