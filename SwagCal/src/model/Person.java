package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import controller.Controller;

public class Person implements Databaseable {
	private int personID;
	private String navn;
	private int phoneNumber;
	private String userName;
	private String password;
	private ArrayList<Event> events;
	private ArrayList<Notification> notifications;
	private PropertyChangeSupport pcs;
	private Controller contr;
	
	
	//Setter propertychange listener
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	//Setter kontroller
	public void setController(Controller c){
		this.contr = c;
	}
	
	//Konstruktør
	public Person(int id, String navn, int phoneNumber,String userName, String password) {
		this.personID = id;
		this.navn = navn;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
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
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getPhoneNumber() {
		return phoneNumber;
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
	public ArrayList<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(ArrayList<Notification> notifications) {
		this.notifications = notifications;
	}
	
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
	
	public void deleteEvent(Event e) {
		events.remove(e);
	}
	
	
}
