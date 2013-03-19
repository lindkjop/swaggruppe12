package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import tools.dateTime;
import controller.Controller;

public class Event implements Databaseable {
	private int eventID;
	
	private dateTime dateFrom;
	private dateTime dateTo;
	private dateTime startTime;
	private dateTime endTime;
	private String description;
	private String location;
	private Person creator;
	private Room room;
	private Group group;
	
	
	private ArrayList<Person> invited;
	private ArrayList<Person> accepted;
	private ArrayList<Person> declined;
	private Map arguments;
	
	
	
	//Event listener support
	private PropertyChangeSupport pcs;
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	//KonstruktÝr
	public Event(dateTime from, dateTime to, String description, String location,Person creator, Room room){
		this.from = from;
		this.to = to;
		this.description = description;
		this.location = location;
		this.creator = creator;
		this.room = room;
	}
	
	//GET & SET
	
	//Tidspunkt
	public dateTime getDuration() {
		return dateTime.getDuration(this.from, this.to);
	}
	
	public void setFrom(dateTime from){
		this.from = from;
	}
	public void setTo(dateTime to){
		this.from = to;
	}
	public dateTime getFrom(){
		return this.from;
	}
	public dateTime getTo(){
		return this.to;
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
		return dateTime.intersects(from, to, e.getFrom(), e.getTo());
	}

	@Override
	public Set getArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createArguments() {
		Map arguments = new HashMap<String, String>();
		arguments.put("EventID", eventID);
		arguments.put("dateTo", dateTo.);
		arguments.put("dateFrom", value);
		arguments.put("timeFrom", value);
		arguments.put("timeTo", value);
		arguments.put("description", description);
		arguments.put("location", location);
		arguments.put("ownerID", creator.getPersonID());
		arguments.put("roomNR", room);
		arguments.put("groupsID", group.getID());
		
	}
	
 
}
