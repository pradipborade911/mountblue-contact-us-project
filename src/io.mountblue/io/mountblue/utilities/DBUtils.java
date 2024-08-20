package io.mountblue.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnetion() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection connection;
		
        String url = "jdbc:postgresql://localhost:5432/mb_servlet";
        String user = "pradipborade";
        String password = "postgres";
		
        connection = DriverManager.getConnection(url, user, password);	
        
		return connection;
	}
}
