package io.mountblue.pages;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mountblue.dao.RequestsDao;
import io.mountblue.dao.RequestsDaoImpl;
import io.mountblue.pojos.Request;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	RequestsDao requestsDao;

	@Override
	public void init() throws ServletException {
		requestsDao = new RequestsDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("user")==null) {
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			return;
		}	
		
		List<Request> allUnarchivedRequests = requestsDao.getAllUnarchivedRequests();
		List<Request> allArchivedRequests = requestsDao.getAllArchivedRequests();
		
		req.setAttribute("allUnarchivedRequests", allUnarchivedRequests);
		req.setAttribute("allArchivedRequests", allArchivedRequests);
		RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int requestId = Integer.parseInt(req.getParameter("id"));
		String status = req.getParameter("status");
		boolean isActive = status.equals("Active") ? true : false;
		
		boolean isSuccessful = requestsDao.changeStatus(requestId, isActive);
		
		resp.sendRedirect("dashboard");
	}

}
