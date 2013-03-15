package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import tools.dateTime;

public class Event {
	private int eventID;
	private dateTime duration;
	private String description;
	private String location;
	private Person creator;
	private ArrayList<Person> invited;
	private ArrayList<Person> accepted;
	private ArrayList<Person> declined;
	private Room room;
	
	
	
	
	//Event listener support
	private PropertyChangeSupport pcs;
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public Event(int eventID, dateTime duration, String description, String location,Person creator, Room room){
		this.eventID = eventID;
		this.duration = duration;
		this.description = description;
		this.location = location;
		this.creator = creator;
		this.room = room;
		
	}
	
	//Tidspunkt
	public dateTime getDuration() {
		return duration;
	}
	public void setDuration(dateTime time) {
		this.duration = time;
	}
	
	//Tekstlig beskrivelse av eventen
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	//Rom
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	//Tilknyttning til person som opretter event.
	public Person getCreator() {
		return creator;
	}
	public void setCreator(Person creator) {
		this.creator = creator;
	}
	
	//Invited listen
	public ArrayList<Person> getInvited() {
		return invited;
	}
	public void setInvited(ArrayList<Person> invited) {
		this.invited = invited;
	}
	public void addInvited(Person p){
		this.invited.add(p);
	}
	
	
	//Accepted listen
	public ArrayList<Person> getAccepted() {
		return accepted;
	}
	public void setAccepted(ArrayList<Person> accepted) {
		this.accepted = accepted;
	}
	
	//Declined listen
	public ArrayList<Person> getDeclined() {
		return declined;
	}
	public void setDeclined(ArrayList<Person> declined) {
		this.declined = declined;
	}
	
	//Konflikt med andre events-logikk
	public boolean conflictsWith(Event e) {
		return this.getDuration().intersects(e.getDuration());
	}
	
 
}
