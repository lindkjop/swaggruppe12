package db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import tools.dateTime;

import model.Event;
import model.Notification;
import model.Person;
import model.Room;


public class Factory {
	
	DBConnection db;
	
	
	public Factory(Properties properties) throws ClassNotFoundException, SQLException
	{
		 db = new DBConnection(properties);
	}
	
	
	public Person getPerson(int id) throws ClassNotFoundException, SQLException {
		db.initialize();
		
		String query = String.format("SELECT * FROM PERSON WHERE ID=%a",id);
		
		ResultSet rs = db.makeSingleQuery(query);
		String name = null;
		int telefon = -1;
		String brukernavn = null;
		String password = null;
		
		while(rs.next()) {
			name = rs.getString(2);
			telefon = rs.getInt(3);
			password = rs.getString(4);
		}
		
		rs.close();
		db.close();
		
		return new Person(id, name,telefon,password);
		

		
		
		
		
		
	}



	public Event getEvent(int id) throws ClassNotFoundException, SQLException {
		
		db.initialize();
		
		String query = String.format("SELECT * FROM Event WHERE ID=%a",id);
		
		ResultSet rs = db.makeSingleQuery(query);
		int date = -1;
		int startTime = -1;
		int endTime = -1;
		String description = null;
		String location = null;
		Person creator = null;
		Room room = null;
		int groups = -1;
		
		while(rs.next()) {
			date = rs.getInt(2);
			startTime = rs.getInt(3);
			endTime = rs.getInt(4);
			description = rs.getString(5);
			location = rs.getString(6);
			room = getRoom(rs.getInt(7));
			creator = getPerson(rs.getInt(8));
		}
		
		
		dateTime duration = new dateTime();
		// Code to set duration object here.
		
		rs.close();
		db.close();
		
		return new Event(id, duration, description, location, creator, room);
		
	}
	
	
	public Room getRoom(int id) throws SQLException, ClassNotFoundException {
		
		db.initialize();
		
		String query = String.format("SELECT * FROM Room WHERE ID=%a",id);
		
		ResultSet rs = db.makeSingleQuery(query);
		int roomNR = -1;
		String roomName = null;
		int roomSize = -1;
		
		while(rs.next()) {
			roomNR = rs.getInt(1);
			roomName = rs.getString(2);
			roomSize = rs.getInt(3);
		}
		
		rs.close();
		db.close();
		
		return new Room(roomNR, roomName, roomSize);
	
		
		
	}
	

	public Notification getNotification(int id) throws SQLException, ClassNotFoundException {
		
		db.initialize();
		
		String query = String.format("SELECT * FROM Notification WHERE ID=%a",id);
		
		ResultSet rs = db.makeSingleQuery(query);
		
		String message = null;
		int date = -1;
		int dateCreated = -1;
		int timeCreated = -1;
		dateTime created = null;
		Boolean isRead = null;
		String location = null;
		Room room= null;
		Person owner = null;
		dateTime alarm = null;
		int dateAlarm = -1;
		int timeAlarm = -1;
		
		boolean isActive;
		dateTime start;
		Person owner;
		Event event;
		
		while(rs.next()) {
			message = rs.getString(2);
			dateCreated = rs.getInt(3);
			timeCreated = rs.getInt(4);
			isRead = rs.getBoolean(5);
			Person ownerID = getPerson(rs.getInt(6));
			dateAlarm = rs.getInt(7);
			timeAlarm = rs.getInt(8);
		}
		
		
		dateTime duration = new dateTime();
		duration.setDate(date);
		duration.setTime(startTime);
		
		rs.close();
		db.close();
		
		return null;
		
		return new Notification(id, isActive, description, location, creator, room);
		
		
		
		
		}
	}