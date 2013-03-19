package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import tools.dateTime;
import controller.Controller;

public class Event /*implements Databaseable */{
	
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
	private String title;
	
	private ArrayList<Person> invited;
	private ArrayList<Person> accepted;
	private ArrayList<Person> declined;
	private Map<String,String> arguments;
	
	//Event listener support
	private PropertyChangeSupport pcs;
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	//Konstruktør
	public Event(dateTime from, dateTime to, String description, String location,Person creator, Room room){
		this.startTime = from;
		this.endTime = to;
		this.description = description;
		this.location = location;
		this.creator = creator;
		this.room = room;
	}
	
	//GET & SET
	
	//Tidspunkt
	public dateTime getDuration() {
		return dateTime.getDuration(this.startTime, this.endTime);
	}
	
	public void setFrom(dateTime from){
		this.startTime = from;
	}
	public void setTo(dateTime to){
		this.endTime = to;
	}
	public dateTime getFrom(){
		return this.startTime;
	}
	public dateTime getTo(){
		return this.endTime;
	}
	
	//Dato
	public dateTime getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(dateTime dateFrom) {
		this.dateFrom = dateFrom;
	}
	public dateTime getDateTo() {
		return dateTo;
	}
	public void setDateTo(dateTime dateTo) {
		this.dateTo = dateTo;
	}
	
	public int getID() {
		return this.eventID;
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
	
	//Title setter/getter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return dateTime.intersects(this.getFrom(), this.getTo(), e.getFrom(), e.getTo());
	}


	public Map getArguments() {
		createArguments();
		return this.arguments;
	}

	public void createArguments() {
		arguments = new HashMap<String, String>();
		arguments.put("EventID", Integer.toString(eventID));
		arguments.put("dateTo", dateTo.getDate());
		arguments.put("dateFrom", dateFrom.getDate());
		arguments.put("timeFrom", startTime.getTime());
		arguments.put("timeTo", endTime.getTime());
		arguments.put("description", description);
		arguments.put("location", location);
		arguments.put("ownerID", Integer.toString(creator.getPersonID()));
		arguments.put("roomNR", Integer.toString(room.getRoomNumber()));
		arguments.put("groupsID", Integer.toString(group.getID()));
		
	}
	
 
}
