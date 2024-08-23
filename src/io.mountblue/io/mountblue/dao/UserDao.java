package io.mountblue.dao;

import io.mountblue.pojos.User;

public interface UserDao{
	public boolean createAdmin(String name, String username, String email, String password);
	
	public User authenticateUser(String username, String password);
}
