package model;

import java.util.ArrayList;

import tools.dateTime;

public class Event {
	private dateTime period;
	private String description;
	private String location;
	private Person creator;
	private ArrayList<Person> invited;
	private ArrayList<Person> accepted;
	private ArrayList<Person> declined;
	private Room room;
	
	public Event(){
		//Konstrukør logikk her plz
	}
	
	//Tidspunkt
	public dateTime getTime() {
		return period;
	}
	public void setTime(dateTime time) {
		this.period = time;
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
	public boolean confictsWith(Event e) {
		//
	}
	
 
}
