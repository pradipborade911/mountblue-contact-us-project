package io.mountblue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import io.mountblue.pojos.Request;
import io.mountblue.pojos.User;
import io.mountblue.utilities.DBUtils;

public class RequestsDaoImpl implements RequestsDao {

	@Override
	public boolean saveRequest(Request contactRequest) {
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
	public List<Request> getAllUnarchivedRequests() {
		List<Request> allUnarchivedRequests = new ArrayList<Request>();
		
		try (Connection connection = DBUtils.getConnetion()) {
			String query = "SELECT id, full_name, email, message FROM requests WHERE active=true";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String message = resultSet.getString(4);
				
				Request conatctRequest = new Request();
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
	public List<Request> getAllArchivedRequests() {
		List<Request> allArchivedRequests = new ArrayList<Request>();
		
		try (Connection connection = DBUtils.getConnetion()) {
			String query = "SELECT id, full_name, email, message FROM requests WHERE active=false";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String fullName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String message = resultSet.getString(4);
				
				Request conatctRequest = new Request();
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
	public boolean changeStatus(int requestId, boolean isActive) {
	try (Connection connection = DBUtils.getConnetion()) {
		String query = "UPDATE requests SET active=? WHERE id=?";
		
		System.out.println(isActive);
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setBoolean(1, isActive);
		statement.setInt(2, requestId);
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
