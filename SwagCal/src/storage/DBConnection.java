package storage;

import java.sql.Connection;
import java.util.Properties;



public class DBConnection {
	private Properties properties; // file containing the connection properties
	private String jdbcDriver; // String containing the driver Class name
	private String url; // Address to the database
	private Connection conn;
	
	public DBConnection(){
		
	}

	

}
