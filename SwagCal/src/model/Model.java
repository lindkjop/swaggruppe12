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
//		initialize();
	}
	public Model(){
		events = new ArrayList<Event>(); 
		groups = new ArrayList<Group>();
		notifications = new ArrayList<Notification>();
		rooms = new ArrayList<Room>();
		persons = new ArrayList<Person> ();
	}
	
	public ArrayList<Person> getPersons(){
		return persons;
	}
	public void addPerson(Person p){
		persons.add(p);
	}
	
	
	public void addEvent(Event e) {
		events.add(e);
	}
	
	public ArrayList<Event> getEvents() {
		return events;
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
	
	public Person findPerson(int id) {
		for (Person p : persons) {
			if (p.getPersonID() == id) {
				return p;
			}
		}
		return null;
	}
	
	public Event findEvent(int id) {
		for (Event e : events) {
			if (e.getID() == id) {
				return e;
			}
		}
		return null;
	}
	
	public Notification findNotification(int id) {
		for (Notification n : notifications) {
			if (n.getID() == id) {
				return n;
			}
		}
		return null;
	}
	
	public Group findGroup(int id) {
		for (Group g : groups) {
			if (g.getID() == id) {
				return g;
			}
		}
		return null;
	}
	
	public Room findRoom(int nr) {
		for (Room r : rooms) {
			if (r.getRoomNumber() == nr) {
				return r;
			}
		}
		return null;
	}
	
//	public void initialize() {
//		events = factory.getEvents();
//		groups = factory.getGroups();
//		notifications = factory.getNotifications();
//		persons = factory.getPersons();
//		rooms = factory.getRooms();
//	}
	
}
