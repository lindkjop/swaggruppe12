package db;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import db.DBConnection;

import tools.dateTime;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;


public class Factory {

	DBConnection db;


	
	public ResultSet doQuery(String query) {
		
		try {
			db.initialize();
			ResultSet rs = db.makeSingleQuery(query);
			return rs;
		}
			
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			System.out.println("Dette gikk ikke!");
		}
		
		return null;
	}
	
	
	public Factory(Properties properties) throws ClassNotFoundException, SQLException
	{
		db = new DBConnection(properties);
	}

	public Factory(String filename) throws ClassNotFoundException, IOException, SQLException
	{
		db = new DBConnection(filename);
	}
		
	
	public void doUpdate(String query) {
			
			try {
				db.initialize();
				db.makeSingleUpdate(query);
			}
			
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			catch (SQLException e) {
				System.out.println("Dette gikk ikke!");
			}
			
	}
			
	public DBConnection getDbConnection(){
		return db;
	}




}

