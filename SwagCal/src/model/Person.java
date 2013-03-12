package model;

import java.util.ArrayList;

public class Person {
	private int personID;
	private String navn;
	private int phoneNumber;
	private ArrayList<Event> events;
	private ArrayList<Notification> notifications;
	
	
	//GET & Set
	public int getPersonID() {
		return personID;
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
