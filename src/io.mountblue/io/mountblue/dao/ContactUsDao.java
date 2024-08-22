package io.mountblue.dao;

import java.util.List;

import io.mountblue.pojos.ContactRequest;

public interface ContactUsDao {
	boolean createContactUsRequest(ContactRequest contactRequest);
	
	List<ContactRequest> getAllUnarchivedRequests();

	List<ContactRequest> getAllArchivedRequests();

	boolean archiveRequest(int id);

	boolean deleteRequest(int id);
}
