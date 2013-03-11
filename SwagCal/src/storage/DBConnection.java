package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DBConnection {
	private Properties prop; // Filnavnet til properties filen
	private String jdbcDriver; // Driverens klassenavn
	private String url; // Adressen til databasen
	private Connection conn; // Forbindelse
	
	public DBConnection(String propFilename) throws IOException{
		//Laster inn properties filen
		File file = new File(propFilename);
		FileInputStream fip = new FileInputStream(file);
		prop = new Properties();
		prop.load(fip);
		
		//Laster inn info fra properties filen
		jdbcDriver = prop.getProperty("jdbcDriver");
		url = prop.getProperty("url");
	}

	public void initConnetcion() throws ClassNotFoundException, SQLException{
		Class.forName(jdbcDriver);
		Properties  info = new Properties();
		
		/*
		 * info is a different Properties object from the "properties" one.
		 * "info" is used by the Driver Manager while properties is used by our
		 * program
		 */
		
		info.setProperty("user", prop.getProperty("user"));
		info.setProperty("password", prop.getProperty("password"));
		conn = DriverManager.getConnection(url, info);
	}


	/**
	 * 
	 * Used for SELECT queries
	 * 
	 * 
	 * @param sql
	 *            The query in SQL.No semicolon (;) is needed
	 * @return A result set containing the data.
	 * @throws SQLException
	 */
	public ResultSet makeSingleQuery(String sql) throws SQLException {
		Statement st = conn.createStatement();
		return st.executeQuery(sql);
	}

	/**
	 * Used for single or few insertions, deletions and updates
	 * 
	 * @param sql
	 *            The query in SQL.No semicolon (;) is needed.
	 * @throws SQLException
	 */
	public void makeSingleUpdate(String sql) throws SQLException {
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}

	/**
	 * 
	 * Used for batch selections, insertions or other queries
	 * 
	 * @param sql
	 *            The query in SQL.No semicolon (;) is needed.
	 * @return
	 * 			Returns a PreparedStatement for the query. See the description of the PreparedStatement
	 * @throws SQLException
	 */
	public PreparedStatement preparedStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	public void close() throws SQLException {
		conn.close();
	}

}
