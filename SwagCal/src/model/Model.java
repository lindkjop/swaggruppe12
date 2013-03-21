package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import db.Factory;

public class Model {

	private Factory factory;
	
	private ArrayList<Event> events;
	private ArrayList<Group> groups;
	private ArrayList<Notification> notifications;
	private ArrayList<Person> persons;
	private ArrayList<Room> rooms;
	
	public final static String EVENTS_PORPERTY = "eventsArray";
	public final static String GROUPS_PROPERTY = "groupsArray";
	public final static String NOTIFICATIONS_PROPERTY = "notificationsArray";
	public final static String PERSONS_PROPERTY = "personsArray";
	public final static String ROOMS_PROPERTY = "roomsArray";
	private PropertyChangeSupport pcs;
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	
	public Model(Factory f) {
		this.factory = f;
		pcs = new PropertyChangeSupport(this);
//		initialize();
	}
	public Model(){
		events = new ArrayList<Event>(); 
		groups = new ArrayList<Group>();
		notifications = new ArrayList<Notification>();
		rooms = new ArrayList<Room>();
		persons = new ArrayList<Person> ();
	}
	
	public void addPerson(Person p){
		
		this.persons.add(p);

	}
	
	public ArrayList<Person> getPersons(){
		return persons;
	}

	
	public void addEvent(Event e) {
		ArrayList<Event> oldList = this.events;
		events.add(e);
		pcs.firePropertyChange(EVENTS_PORPERTY, oldList, this.events);
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}
			
	public void addNotification(Notification n) {
		ArrayList<Notification> oldList = this.notifications;
		notifications.add(n);
		pcs.firePropertyChange(NOTIFICATIONS_PROPERTY, oldList, this.notifications);
	}
		
	public void removeEvent(Event e) {
		ArrayList<Event> oldList = this.events;
		events.remove(e);
		pcs.firePropertyChange(EVENTS_PORPERTY, oldList, this.events);
	}
	
	public void removeNotification(Notification n) {
		ArrayList<Notification> oldList = this.notifications;
		notifications.remove(n);
		pcs.firePropertyChange(NOTIFICATIONS_PROPERTY, oldList, this.notifications);
	
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
