package db;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import tools.dateTime;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;


public class Factory {

	DBConnection db;


	public Factory(Properties properties) throws ClassNotFoundException, SQLException
	{
		db = new DBConnection(properties);
	}

	public Factory(String filename) throws ClassNotFoundException, IOException, SQLException
	{
		db = new DBConnection(filename);
	}


	public Person getPerson(int id) throws ClassNotFoundException, SQLException {
		db.initialize();

//		String query = String.format("SELECT * FROM PERSON WHERE ID=%a",String.valueOf(id));
		String query = String.format("SELECT * FROM PERSON WHERE ID="+String.valueOf(id));

		ResultSet rs = db.makeSingleQuery(query);
		String name = null;
		int telefon = -1;
		String username = null;
		String password = null;

		while(rs.next()) {
			name = rs.getString(2);
			telefon = rs.getInt(3);
			username = rs.getString(4);
			password = rs.getString(5);
		}

		rs.close();
		db.close();

		return new Person(id, name,telefon, username,password);







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


		dateTime start = new dateTime();
		start.setTime(startTime);
		dateTime end = new dateTime();
		end.setTime(endTime);
		dateTime duration = new dateTime(start, end);

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
		int dateCreated = -1;
		int timeCreated = -1;
		dateTime created = null;
		Boolean isRead = null;
		Person owner = null;
		dateTime alarm = null;
		int dateAlarm = -1;
		int timeAlarm = -1;

		dateTime start = null;
		Event event = null;

		while(rs.next()) {
			event = getEvent(rs.getInt(2));
			message = rs.getString(3);
			dateCreated = rs.getInt(4);
			timeCreated = rs.getInt(5);
			isRead = rs.getBoolean(6);
			Person ownerID = getPerson(rs.getInt(7));
			dateAlarm = rs.getInt(8);
			timeAlarm = rs.getInt(9);
		}


		created = new dateTime();

		created.setDate(dateCreated);
		created.setTime(timeCreated);

		alarm = new dateTime();
		alarm.setDate(dateAlarm);
		alarm.setTime(timeAlarm);




		rs.close();
		db.close();

		return new Notification(id, event, message, isRead, start, alarm, owner);

	}


	public Group getGroup(int id) throws SQLException, ClassNotFoundException {

		return new Group(id);

	}




	public void addPersonToDB(Person p) throws ClassNotFoundException, SQLException {
		
		String navn = p.getNavn();
		int phoneNumber = p.getPhoneNumber();
		String brukerNavn = p.getUserName();
		String password = p.getPassword();
		
		
		db.initialize();

		String statement;
		statement = String.format("INSERT INTO Person VALUES (null,'%s',%s,'%s','%s')",navn,phoneNumber,brukerNavn, password);		
		db.makeSingleUpdate(statement);
		db.close();
	}


	public void addEventToDB(Event e) throws ClassNotFoundException, SQLException {
		db.initialize();
		
		int duration = 10;
		String description = e.getDescription();
		String location = e.getLocation();
		int creator = e.getCreator().getPersonID(); 
		int roomNumber = e.getRoom().getRoomNumber();
		
		if(roomNumber != -1) {
			location = null;
			}
		
		
		String statement;
		statement = String.format("INSERT INTO Person VALUES (null,%s,'%s','%s',%s)",duration,description,location, creator, roomNumber);		
		db.makeSingleUpdate(statement);
		db.close();
	}
	
	
	
	public int getCountOfModel(Object model) throws ClassNotFoundException, SQLException {
		
		String modelname = model.getClass().getName();
		return 3;
		
	
		
		
	}

	public ArrayList<Event> getEvents() {
		try {
			db.initialize();

		ArrayList<Event> events = new ArrayList<Event>();
		String query = String.format("SELECT * FROM Event");

		ResultSet rs = db.makeSingleQuery(query);
		while(rs.next()) {
			int id = rs.getInt(1);
			int date = rs.getInt(2);
			int startTime = rs.getInt(3);
			int endTime = rs.getInt(4);
			String description = rs.getString(5);
			String location = rs.getString(6);
			Room room = getRoom(rs.getInt(7));
			Person creator = getPerson(rs.getInt(8));
			
			
			dateTime start = new dateTime();
			start.setTime(startTime);
			dateTime end = new dateTime();
			end.setTime(endTime);
			dateTime duration = new dateTime(start, end);


			events.add(new Event(id, duration, description, location, creator, room));
		}
		rs.close();
		db.close();
		
		return events;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Person> getPersons() {
		try {
			db.initialize();

		String query = String.format("SELECT * FROM Person");

		ResultSet rs = db.makeSingleQuery(query);
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public ArrayList<Notification> getNotifications() {
		try {
			db.initialize();

		String query = String.format("SELECT * FROM Notification");

		ResultSet rs = db.makeSingleQuery(query);

		ArrayList<Notification> notifications = new ArrayList<Notification>();
		int id;
		String message;;
		int dateCreated;
		int timeCreated;
		dateTime created;
		Boolean isRead;
		Person owner = null;
		dateTime alarm;
		int dateAlarm;
		int timeAlarm;

		dateTime start=null;
		Event event=null;

		while(rs.next()) {
			id = rs.getInt(0);
			event = getEvent(rs.getInt(2));
			message = rs.getString(3);
			dateCreated = rs.getInt(4);
			timeCreated = rs.getInt(5);
			isRead = rs.getBoolean(6);
			Person ownerID = getPerson(rs.getInt(7));
			dateAlarm = rs.getInt(8);
			timeAlarm = rs.getInt(9);
			


			created = new dateTime();
	
			created.setDate(dateCreated);
			created.setTime(timeCreated);
	
			alarm = new dateTime();
			alarm.setDate(dateAlarm);
			alarm.setTime(timeAlarm);

			notifications.add(new Notification(id, event, message, isRead, start, alarm, owner));
		}



		rs.close();
		db.close();

		return notifications;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Room> getRooms() {
		try {
			db.initialize();

		ArrayList<Room> rooms = new ArrayList<Room>();
		String query = String.format("SELECT * FROM Room");

		ResultSet rs = db.makeSingleQuery(query);
		
		while(rs.next()) {
			int roomNR = rs.getInt(1);
			String roomName = rs.getString(2);
			int roomSize = rs.getInt(3);
			
			rooms.add(new Room(roomNR, roomName, roomSize));
		}

		rs.close();
		db.close();

		return rooms;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Group> getGroups() {
		try {
			db.initialize();

		String query = String.format("SELECT * FROM Group");

		ResultSet rs = db.makeSingleQuery(query);
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




}

