package io.mountblue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import io.mountblue.pojos.ContactRequest;
import io.mountblue.pojos.Admin;
import io.mountblue.utilities.DBUtils;

public class ContactUsDaoImpl implements ContactUsDao {

	@Override
	public boolean createContactUsRequest(ContactRequest contactRequest) {
		try (Connection connection = DBUtils.getConnetion()) {
			String query = "INSERT INTO requests(full_name, email, message) VALUES(?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, contactRequest.getFullName());
			statement.setString(2, contactRequest.getEmail());
			statement.setString(3, contactRequest.getMessage());
			int rows = statement.executeUpdate();

			if (rows == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ContactRequest> getAllUnarchivedRequests() {
		List<ContactRequest> allUnarchivedRequests = new ArrayList<ContactRequest>();
		
		try (Connection connection = DBUtils.getConnetion()) {
			String query = "SELECT id, full_name, email, message FROM requests WHERE status='Active'";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String message = resultSet.getString(4);
				
				ContactRequest conatctRequest = new ContactRequest();
				conatctRequest.setId(id);
				conatctRequest.setFullName(fullName);
				conatctRequest.setEmail(email);
				conatctRequest.setMessage(message);
				conatctRequest.setStatus("Active");
				
				allUnarchivedRequests.add(conatctRequest);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUnarchivedRequests;
	}

	@Override
	public List<ContactRequest> getAllArchivedRequests() {
		List<ContactRequest> allArchivedRequests = new ArrayList<ContactRequest>();
		
		try (Connection connection = DBUtils.getConnetion()) {
			String query = "SELECT id, full_name, email, message FROM requests WHERE status='Archived'";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String message = resultSet.getString(4);
				
				ContactRequest conatctRequest = new ContactRequest();
				conatctRequest.setId(id);
				conatctRequest.setFullName(fullName);
				conatctRequest.setEmail(email);
				conatctRequest.setMessage(message);
				conatctRequest.setStatus("Archived");
				
				allArchivedRequests.add(conatctRequest);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allArchivedRequests;
	}

	@Override
	public boolean archiveRequest(int id) {
		try (Connection connection = DBUtils.getConnetion()) {
			String query = "UPDATE requests SET status='Archived' WHERE id=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			int rows = statement.executeUpdate();

			if (rows == 1) {
				return true;
			}
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRequest(int id) {
		try (Connection connection = DBUtils.getConnetion()) {
			String query = "DELETE FROM requests WHERE id=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			int rows = statement.executeUpdate();

			if (rows == 1) {
				return true;
			}
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
