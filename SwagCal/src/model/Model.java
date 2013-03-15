package model;

import java.util.ArrayList;

import db.Factory;

public class Model {

	private Person person;
	private Factory factory;
	
	private ArrayList<Event> events;
	private ArrayList<Group> groups;
	private ArrayList<Notification> notifications;
	private ArrayList<Person> persons;
	private ArrayList<Room> rooms;
	
	public Model(Factory f) {
		this.factory = f;
		initialize();
	}
	public Model(){
		events = new ArrayList<Event>(); 
		groups = new ArrayList<Group>();
		notifications = new ArrayList<Notification>();
		rooms = new ArrayList<Room>();
		persons = new ArrayList<Person> ();
	}
	public void addPerson(Person p){
		persons.add(p);
	}
	
	public ArrayList<Person> getPersons(){
		return persons;
	}
	
	
	public void addEvent(Event e) {
		events.add(e);
	}
			
	public void addNotification(Notification n) {
		notifications.add(n);
	}
		
	public void removeEvent(Event e) {
		events.remove(e);
	}
	
	public void removeNotification(Notification n) {
		notifications.remove(n);
	
	}
	public void updateEvent(Event oldE, Event newE) {
		events.remove(oldE);
		events.add(newE);
	}
	
	public void updateNotification(Notification oldN, Notification newN) {
		notifications.remove(oldN);
		notifications.add(newN);
	}
	
	public void initialize() {
		events = factory.getEvents();
		groups = factory.getGroups();
		notifications = factory.getNotifications();
		persons = factory.getPersons();
		rooms = factory.getRooms();
	}
	
}
