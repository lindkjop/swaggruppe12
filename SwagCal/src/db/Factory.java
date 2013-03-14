package db;

import Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class Factory {
	
	DBConnection db;
	
	
	public Factory(Properties properties) throws ClassNotFoundException, SQLException
	{
		 db = new DBConnection(properties);
	}
	

}
