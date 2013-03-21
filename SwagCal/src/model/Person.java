package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tools.Stringify;

import controller.Controller;

/**
 * Klasse som representerer en person/bruker.
 * Inneholder personinfo som navn og telefonnummer,
 * og systeminfo som brukernavn og passord.
 * Inneholder også lister med avtaler personen
 * er invitert til, og tilhørende varsler.
 */

public class Person  {
	private int personID;
	private String name;
	private int phoneNumber;
	private String userName;
	private String password;
	private ArrayList<Event> events;
	private ArrayList<Notification> notifications;
	private PropertyChangeSupport pcs;
	private Controller contr;
	private Map<String,String> arguments;
	
	//Setter propertychange listener
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	//Setter kontroller
	public void setController(Controller c){
		this.contr = c;
	}
	
	//Konstruktør
	public Person(String name, int phoneNumber,String userName, String password) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		createArguments();
	}
	
	//GET & Set
	public int getPersonID() {
		return personID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public Map getArguments() {
		createArguments();
		return arguments;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	public void addEvent(Event event) {
		events.add(event);
	}
	public ArrayList<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(ArrayList<Notification> notifications) {
		this.notifications = notifications;
	}
	
//	Metode som sjekker en persons avtaler, og returnerer en liste over alle avtalene som kolliderer med minst en annen av personens avtale.
	public ArrayList<Event> getConflictingEvents(){
		ArrayList<Event> result = new ArrayList<Event>();
		for (Event a:events){
			for(Event b: events){
				if(!a.conflictsWith(b) && a!=b){
					result.add(a);
				}
			}
		}
		return result;
	}
	
//	Metode for å slette avtale fra personens liste.
	public void deleteEvent(Event e) {
		events.remove(e);
	}
	
//	Metode som fyller arguments-hashmappet med felter/verdier fra dette objektet.
	public void createArguments() {
		arguments = new HashMap<String, String>();
		arguments.put("personID", "#ID#");
		arguments.put("name", Stringify.makeString(this.name));
		arguments.put("phoneNumber", Integer.toString(phoneNumber));
		arguments.put("userName", Stringify.makeString(this.userName));
		arguments.put("passWord", Stringify.makeString(this.password));
}


	
	
}
