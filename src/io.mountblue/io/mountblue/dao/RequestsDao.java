package io.mountblue.dao;

import java.util.List;

import io.mountblue.pojos.Request;

public interface RequestsDao {
	boolean saveRequest(Request contactRequest);
	
	List<Request> getAllUnarchivedRequests();

	List<Request> getAllArchivedRequests();

	boolean changeStatus(int requestId, boolean isActive);
}
