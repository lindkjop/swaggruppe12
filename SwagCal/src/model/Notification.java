package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import controller.Controller;

import tools.Stringify;
import tools.dateTime;

<<<<<<< HEAD
public class Notification implements Databaseable {
	private int id = -1;
=======
public class Notification {
	private int id;
>>>>>>> 669a9a727e2416aa3c06d809275b5776cdc13571
	private String message;
	private boolean isActive;
	private dateTime dateCreated;
	private dateTime timeCreated;
	private dateTime alarmDate;
	private dateTime alarmTime;
	private Person owner;
	private Event event;
	private PropertyChangeSupport pcs;
	private Controller contr;
	private Map<String,String> arguments;
	
	
	//Setter propertychange listener
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	//Setter kontroller
	public void setController(Controller c){
		this.contr = c;
	}
	public Notification(Event event, String message, Boolean isActive, dateTime alarm, Person owner) {
		this.message = message;
		this.isActive = isActive;
		this.owner = owner;
		this.event = event;
		//this.start = start;
	}
	
	//set/get-metoder
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getID() {
		return id;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public boolean isDue() {
	return false;
	}


	public Map getArguments() {
		createArguments();
		return arguments;
	}


		public void createArguments() {
			arguments = new HashMap<String, String>();
			arguments.put("notificationID", "#ID#");
			arguments.put("EventID", Integer.toString(event.getID()));
			arguments.put("messageText", Stringify.makeString(message));
			arguments.put("isRead", Boolean.toString(isActive));
			arguments.put("dateCreated", Stringify.makeString(dateCreated.getDate()));
			arguments.put("timeCreated", Stringify.makeString(timeCreated.getTime()));
			arguments.put("alarmDate", Stringify.makeString(alarmDate.getDate()));
			arguments.put("alarmTime", Stringify.makeString(alarmTime.getTime()));
			arguments.put("ownerID", Integer.toString(owner.getPersonID()));
		
	}
	
}
