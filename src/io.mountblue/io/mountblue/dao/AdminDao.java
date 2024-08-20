package io.mountblue.dao;

import io.mountblue.pojos.Admin;

public interface AdminDao{
	public boolean createAdmin(String name, String username, String email, String password);
	public Admin authenticateAdmin(String username, String password);
}
