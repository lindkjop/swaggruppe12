package db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;
import net.Capsule;

import com.google.gson.Gson;


public class DatabaseFactory {
	
	/* DatabaseFactory brukes til å konstruere en DataBase-query fra Capsule 
	 */
	
	DBConnection db;
	
	Gson gSonObject = new Gson();	
	Capsule capsuleObject;
	
	String className; // KlasseNavnet til modellen som skal manipuleres i databasen
	String conditions; // Betingelser som er satt ved noen av operasjonene, eksempelvis når man skal hente ut data.
	
	String type; /* Type lar oss vite hva slags type Capsule som er sendt oss. Den er ikke i bruk så langt vi har kommet, 
					men kunne vært brukt til å differensiere mellom database-operasjoner og andre type meldinger */ 
	
	String operation;  // Hvilken type operasjon som skal utføres. Kan være "INSERT", "UPDATE", "DELETE" eller "SELECT"
	
	Map<String,String> arguments; /* En map over argumentene som er sendt igjennom capsule. 
	 							   * Disse inneholder navn på databasefelt tilhørende modellobjekter */
	
	String pair; // en streng som inneholder alle argumenter fra arguments i formen "Key=value"
	String keys; // Inneholder hashnøklene fra arguments
	String values; // Inneholder verdiene fra arguments
	
	String dataBaseCommand; // Lagring for en fullstendig kommando som skal gjenkjennes av MySQL.
	
	
	public DatabaseFactory(String objectString)  {
		
	initDB();
	

	capsuleObject = gSonObject.fromJson(objectString, Capsule.class);
	
	className = capsuleObject.getClassName();
	conditions = capsuleObject.getCondition();
	type = capsuleObject.getType();
	operation = capsuleObject.getOperation();

	extractArgumentsFromObject();
	generateQuery();

	
	
	
	}
	
	public void extractArgumentsFromObject() {
	// Trekker ut argumenter fra Capsule
		
	Object o = capsuleObject.getSendObject();
	System.out.println(o);	
	arguments = capsuleObject.getValues();
	
	}
	
	public void initDB() {
	// Lager et nytt DBConnection-objekt
		try {
			db = new DBConnection("./src/db/Properties.properties");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			}
	}
	
	
	public void constructKeysAndValues() {
		// Fyller values og keys med de riktige verdiene fra arguments.
		
		values="";
		keys="";
		
		int i = 0;
		for (Map.Entry<String, String> entry : arguments.entrySet()) {
		
		String v = entry.getValue();
		if(v.equals("#ID#")) {v = "0";}
			
		keys += ", " +  entry.getKey(); 
		values += ", " + v;
		}
		
		keys = keys.substring(2);
		values = values.substring(2);
		
		System.out.println(values);
		System.out.println(keys);

	}
	
	public void constructPairs() {
		// fyller pair med parverdiene fra Arguments. #ID#-felt indikerer at verdien er en primærnøkkel og vil derfor ignoreres.
		
		pair = "";
		for (Map.Entry<String, String> entry : arguments.entrySet()) {
		String v = entry.getValue();
		if(!(v.equals("#ID#"))) {
		pair += ", '" + entry.getKey() + "'" + "= " + entry.getValue();		
		}
		

		System.out.println(pair);
		}
		
		
	}
	
	public void generateQuery() {
		
		/* Genererer en kommando basert på de verdiene som ble sendt igjennom capture. Resultatet er tiltenkt å være en ferdig
		 * Queryen skal nå i prinsippet kunne manipulere databasen gjennom INSERT, UPDATE og DELETE, men metoden kan ikke i
		 * skrivende stund håndtere å sende tilbake informasjon
		 */
		
		
		
	System.out.println("Beginning query!");
	
	if(operation.equals("DELETE") || operation.equals("SELECT")) {
	dataBaseCommand = String.format("DELETE FROM %s WHERE %s ", className, conditions);
	System.out.println(dataBaseCommand);
	executeUpdate();
	}
	
	else if (operation.equals("INSERT")) {
	constructKeysAndValues();
	dataBaseCommand = String.format("INSERT INTO %s (%s) VALUES (%s)" ,className,keys,values);
	System.out.println(dataBaseCommand);		
		
	}
	
	else if (operation.equals("UPDATE")) {
	constructPairs();
	dataBaseCommand = String.format("UPDATE %s SET %s WHERE %s", className, pair, conditions);

	dataBaseCommand = dataBaseCommand.substring(2);
	System.out.println(dataBaseCommand);

	executeUpdate();
	}
	
	else if (operation.equals("SELECT")) {
	dataBaseCommand = String.format("SELECT * FROM %s WHERE %s", className, conditions);
	}	
		

	}


	public String toString() {
		return ("This capsule is a " + type + " command" +
				"\nIt contains the operation " + operation +
				"\nand has the conditions: " + conditions + "." +
				"\nIt contains a " + className + "Class object");
	}
	
	
	public void executeQuery() {
	/* I den ferdige klassen skulle denne metoden være i stand til å utføre en query
	 * og returnere relevant data tilbake til kalleren av klassen.
	 */
	}
	
	public void executeUpdate() {
		// utfører den ferdig konstruerte queryen
		try {
			db.initialize();
			db.makeSingleUpdate(dataBaseCommand);
			db.close();
			System.out.println("Ok!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}


