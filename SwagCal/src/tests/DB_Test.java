package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Event;
import model.Person;

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
	public void test() throws ClassNotFoundException, SQLException, IOException {
		DB_Factory();
		
		DB_Person();
		DB_EmptyTable("Person");
		
		DB_Event();
		DB_EmptyTable("Event");
	}

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

		f.addPersonToDB(new Person(0, "Geir Anus", 999996, "giera", "penis"));
		Person p1 = f.getPerson(1);

	}
	
	//Prøver å sette inn et event og hente det ut etterpå
	public void DB_Event() {

		//Prøver å legge til event
		Event e1 = new Event(0, null, "Hellige møteplass!", "Drepe!", testPerson1, null);
		
	}

}
