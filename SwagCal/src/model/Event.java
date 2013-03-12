package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
	private Date dateTime;
	private String description;
	private String location;
	private Person creator;
	private ArrayList<Person> invited;
	private ArrayList<Person> accepted;
	private ArrayList<Person> declined;
	private Room room;
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date time) {
		this.dateTime = time;
	}
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
	public Person getCreator() {
		return creator;
	}
	public void setCreator(Person creator) {
		this.creator = creator;
	}
	public ArrayList<Person> getInvited() {
		return invited;
	}
	public void setInvited(ArrayList<Person> invited) {
		this.invited = invited;
	}
	public ArrayList<Person> getAccepted() {
		return accepted;
	}
	public void setAccepted(ArrayList<Person> accepted) {
		this.accepted = accepted;
	}
	public ArrayList<Person> getDeclined() {
		return declined;
	}
	public void setDeclined(ArrayList<Person> declined) {
		this.declined = declined;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public boolean isConflicting (Person p) {
		return true;
	}
	
 
}
