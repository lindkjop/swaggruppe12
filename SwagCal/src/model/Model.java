package model;

import java.util.ArrayList;

public class Model {

	private ArrayList<Event> events;
	private ArrayList<Group> groups;
	private ArrayList<Notification> notifications;
	private ArrayList<Person> persons;
	private ArrayList<Room> rooms;
	
	public void addEvent(Event e) {
		events.add(e);
		
	}
	
	public void addGroup(Group g) {
		groups.add(g);
	}
	
	public void addNotification(Notification n) {
		notifications.add(n);
	}
	
	public void addPerson(Person p) {
		persons.add(p);
	}
	
	public void addRoom(Room r) {
		rooms.add(r);
	}
	
	public void removeEvent(Event e) {
		events.remove(e);
	}
	
	public void removeGroup(Group g) {
		groups.remove(g);
	}
	
	public void removeNotification(Notification n) {
		notifications.remove(n);
	}
	
	public void removePerson(Person p) {
		persons.remove(p);
	}
	
	public void removeRoom(Room r) {
		rooms.remove(r);
	}
	
	public void updateEvent(Event oldE, Event newE) {
		events.remove(oldE);
		events.add(newE);
	}
	
	public void updateGroup(Group oldG, Group newG) {
		groups.remove(oldG);
		groups.add(newG);
	}
	
	public void updateNotification(Notification oldN, Notification newN) {
		notifications.remove(oldN);
		notifications.add(newN);
	}
	
	public void updatePerson(Person oldP, Person newP) {
		persons.remove(oldP);
		persons.add(newP);
	}
	
	public void updateRoom(Room oldR, Room newR) {
		rooms.remove(oldR);
		rooms.add(newR);
	}
}
