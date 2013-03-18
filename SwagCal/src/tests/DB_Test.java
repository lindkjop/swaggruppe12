package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Event;
import model.Person;
import model.Room;

import org.junit.Test;

import tools.dateTime;
import db.DBConnection;
import db.Factory;

public class DB_Test {
	private Factory f;
	private DBConnection db;
	private Person testPerson1;
	private Person testPerson2;

	@Test
	
	//Denne funksjoenn blir kjørt!!
	//
	public void test() throws ClassNotFoundException, SQLException, IOException {
		DB_Factory();
		
		DB_EmptyTable("Person");
		DB_Person();
		
		DB_getAllTest();
		
		
//		DB_Event();
//		DB_EmptyTable("Event");
	}

	
	
	//Hjelpe ting som SLETTER HELE BÆSJEN
	private void DB_EmptyTable(String tableName) throws ClassNotFoundException, SQLException {
		db.initialize();
		db.makeSingleUpdate(String.format("DELETE FROM %s",tableName));
		db.close();
		
	}

	//Prøver å lage et nytt factory
	public void DB_Factory() throws ClassNotFoundException, IOException, SQLException{
		f = new Factory("./src/db/Properties.properties");
		db = f.getDbConnection();
	}
	
	
	//Prøver å sette inn en person i db og hente han ut etterpå
	public void DB_Person() throws ClassNotFoundException, SQLException {
		testPerson1 = new Person(1, "Geir Anus", 999996, "giera", "penis");
		f.addPersonToDB(testPerson1);
		Person result = f.getPerson(testPerson1.getPersonID());
		assertEquals(result.getPersonID(), testPerson1.getPersonID());

	}
	
	//Prøver å sette inn et event og hente det ut etterpå
	public void DB_Event() {

		//Prøver å legge til event
		Event e1 = new Event(0, null, "Hellige møteplass!", "Drepe!", testPerson1, null);
		
	}
	public void DB_getAllTest() throws ClassNotFoundException, SQLException {
		f.addEventToDB(new Event(99, new dateTime(), "hei", "hjmme", testPerson1, new Room(10, "hei", 10)));
		f.addEventToDB(new Event(89, new dateTime(), "hei", "hjmme", testPerson1, new Room(11, "hei", 11)));
		ArrayList<Event> events = f.getEvents();
		System.out.println(events);
	}

}
