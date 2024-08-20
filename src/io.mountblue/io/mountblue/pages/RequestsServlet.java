package io.mountblue.pages;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mountblue.dao.ContactUsDao;
import io.mountblue.dao.ContactUsDaoImpl;
import io.mountblue.pojos.ContactRequest;

@WebServlet("/showrequests")
public class RequestsServlet extends HttpServlet {
	ContactUsDao contactUsDao;

	@Override
	public void init() throws ServletException {
		contactUsDao = new ContactUsDaoImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ContactRequest> allUnarchivedRequests = contactUsDao.getAllUnarchivedRequests();
		List<ContactRequest> allArchivedRequests = contactUsDao.getAllArchivedRequests();
		
		req.setAttribute("allUnarchivedRequests", allUnarchivedRequests);
		req.setAttribute("allArchivedRequests", allArchivedRequests);
			
		RequestDispatcher rd = req.getRequestDispatcher("all-requests.jsp");
		rd.forward(req, resp);
	}

}
