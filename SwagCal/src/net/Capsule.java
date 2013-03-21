package net;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;

import com.google.gson.Gson;

/**
 * 
 * @author Daniel
 * 
 */

public class Capsule {

	/**
	 * Capsule er tiltenkt å være en klasse som kan sende informasjon fram og tilbake mellom servere
	 * og klienter. I skrivende stund er den hovedsakelig rettet mot databasemanipulering, men tanken bak var at den
	 * skulle kunne sende både databasemeldinger og andre meldinger som var interessant kommunikasjon mellom server og klient.
	 */

	String type; // Tiltenkt å si litt mer spesifikt om hva slags type data som lå inni Capsule.
	String operation; // For "DATABASE"-typer sier operasjon hva slags databaseoperasjon som skal utføres.
	String classname; // For "DATABASE"-typer sier classname hva slags database som skal endres.
	Boolean doReturnObject; // En teoretisk variabel som aldri ble brukt, men som var tenkt å fortelle mottakeren om at sender forventet et svar
	String condition; // For database-operasjoner ville condition være betingelser som måtte oppfylles: Eksempel: 'PersonID = 4' 
	Object sendObject; // Det var usikkert om denne variabelen trengtes, (eller om alt kunne sendes gjennom arguments). Denne skulle kunne lagre et objekt og sende denne over nettet.
	Map values = new HashMap<String, String>(); // Relevante verdier fra klassen som ble sendt. I "DATABASE"-typer vil denne inneholde alle felt som gjenspeiler databasedataene til objektet som blir definert i ClassName 

	Gson capsulePackage;

	public String pack() {
		// gjør Capsule om til en streng og returnerer denne.
		Gson packagedObject = new Gson();
		return packagedObject.toJson(this); 
	}

	public Capsule(String type, String operation, String classname,
			Boolean doReturnObject) {

		this.type = type;
		this.operation = operation;
		this.classname = classname;
		this.doReturnObject = doReturnObject;
	}

	public Capsule(String type, String operation) {
		this.type = type;
		this.operation = operation;
	}
	
	public void setValues(Map values) {
		this.values = values;
		
	}
	
	public Map getValues() {
		return this.values;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getOperation() {
		return this.operation;
	}
	
	public String getCondition() {
		return this.condition;
	}
	
	public Boolean doReturnObject() {
		return this.doReturnObject;
	}
	
	public String getClassName() {
		return this.classname;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
		
	}

	public void setSendObject(Object sendObject) {
		this.sendObject = sendObject;
	}

	public Object getSendObject() {
		return sendObject;
	}
}
