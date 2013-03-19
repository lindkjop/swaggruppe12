package db;

import java.util.ArrayList;


import model.Event;
import model.Notification;
import model.Person;
import net.Capsule;
import controller.Client;

public class ClientFactory {
	
	private Client client;
	
	public ClientFactory(Client client) {
		this.client = client;
	}

	public Capsule personAddedtoEventInModel(Person person, Event event) {
		return null;
	}
	
	public Capsule personRemovedFromEventInModel(Person person, Event event) {
		return null;
	}
	
	public Capsule eventInfoChangedInModel(Event event) {
		Capsule cap = new Capsule("DATABASE", "UPDATE", "Event", true);
		cap.setCondition("eventID="+event.getID());
		cap.setSendObject(event);
		return cap;
	}
	
	public Capsule eventAddedInModel(Event event) {
		Capsule cap = new Capsule("DATABASE", "INSERT", "Event", true);
		cap.setSendObject(event);
		return cap;
	}
	
	public Capsule eventDeletedInModel(Event event) {
		Capsule cap = new Capsule("DATABASE", "DELETE", "Event", true);
		cap. setCondition("eventID="+event.getID());
		cap.setSendObject(event);
		return cap;
	}
	
	public Capsule alarmChangedInModel(Notification notification) {
		Capsule cap = new Capsule("DATABASE", "UPDATE", "Notification", true);
		cap.setCondition("notificationID="+notification.getID());
		cap.setSendObject(notification);
		return cap;
	}
	
	public void personAddedtoEventInDatabase(Person person, Event event) {
		Person personInModel = client.getModel().findPerson(person.getPersonID());
		Event eventInModel = client.getModel().findEvent(event.getID());
		eventInModel.addInvited(personInModel);
		personInModel.addEvent(eventInModel);
		
	}
	
	public void personRemovedFromEventInDatabase(Person person, Event event) {
		Person personInModel = client.getModel().findPerson(person.getPersonID());
		Event eventInModel = client.getModel().findEvent(event.getID());
		
		person.getEvents().remove(eventInModel);
		
		eventInModel.getInvited().remove(personInModel);
		eventInModel.getAccepted().remove(personInModel);
		eventInModel.getDeclined().remove(personInModel);
		
		
	}
	
	public void eventInfoChangedInDatabase(Event event) {
		Event eventInModel = client.getModel().findEvent(event.getID());
		eventInModel.setDateFrom(event.getDateFrom());
		eventInModel.setDateTo(event.getDateTo());
		eventInModel.setFrom(event.getFrom());
		eventInModel.setTo(event.getTo());
		eventInModel.setDescription(event.getDescription());
		eventInModel.setLocation(event.getLocation());
		eventInModel.setRoom(event.getRoom());
		eventInModel.setTitle(event.getTitle());
	}
	
	public void eventAddedInDatabase(Event event) {
		client.getModel().addEvent(event);
		for (Person p : event.getInvited()) {
			client.getModel().findPerson(p.getPersonID()).addEvent(event);
		}
	}
	
	public void eventDeletedInDatabase(Event event) {
		Event eventInModel = client.getModel().findEvent(event.getID());
		ArrayList<Person> persons = eventInModel.getAccepted();
		persons.addAll(eventInModel.getDeclined());
		persons.addAll(eventInModel.getInvited());
		for (Person p : persons) {
			p.getEvents().remove(eventInModel);
		}
		client.getModel().removeEvent(event);
	}
	
	public void alarmChangedInDatabase(Notification notification) {
		Notification notificationInModel = client.getModel().findNotification(notification.getID());
		notificationInModel.setActive(notification.isActive());
		notificationInModel.setMessage(notification.getMessage());
	}
}
