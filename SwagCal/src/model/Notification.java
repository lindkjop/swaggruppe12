package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import tools.dateTime;

public class Notification {

	private String message;
	private boolean isActive;
	private dateTime start;
	private Person owner;
	private Event event;
	
	private PropertyChangeSupport pcs;
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public dateTime getStart() {
		return start;
	}
	public void setStart(dateTime start) {
		this.start = start;
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
		return this.start.hasPassed();
	}
	
}
