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


@WebServlet("/delete-request")
public class DeleteServletServlet extends HttpServlet {
	
	ContactUsDao contactUsDao;
	
	@Override
	public void init() throws ServletException {
		contactUsDao = new ContactUsDaoImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean isSuccess = contactUsDao.deleteRequest(id);
				
		RequestDispatcher rd = req.getRequestDispatcher("showrequests");
		rd.forward(req, resp);
	}

}
