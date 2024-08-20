package io.mountblue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.mountblue.pojos.Admin;
import io.mountblue.utilities.DBUtils;


public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin authenticateAdmin(String username, String password) {
		try(Connection connection = DBUtils.getConnetion()) {
			String query = "SELECT password, name, email FROM users WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
            	String realPassword = resultSet.getString(1);

            	if(password.equals(realPassword)) {
                	String name =  resultSet.getString(2);                	
                	String email =  resultSet.getString(3);
            		Admin admin = new Admin();
            		admin.setName(name);
            		admin.setUsername(username);
            		admin.setEmail(email);
            		return admin;
            	}
            }

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean createAdmin(String name, String username, String email, String password) {
		try(Connection connection = DBUtils.getConnetion()){
			String query = "INSERT INTO users (name, username, email, password) VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, email);
            statement.setString(4, password);
            
            int rows = statement.executeUpdate();
            
            if(rows == 1) {
            	return true;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}

}