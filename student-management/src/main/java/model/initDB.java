package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class initDB {
	private Connection connection;
	public initDB() {
		try {
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		    } catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    }
		    try {
		      connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "153255");
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	public Connection getConnection() {
		return connection;
	}
}
