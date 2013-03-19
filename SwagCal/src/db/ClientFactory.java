package db;

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

	public Capsule personAddedtoEventInModel(Person p, Event e) {
		return null;
	}
	
	public Capsule personRemovedFromEventInModel(Person p, Event e) {
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
	
	public void personAddedtoEventInDatabase(Person p, Event e) {
		int eventIndex = client.getModel().getEvents().indexOf(e);
		client.getModel().getEvents().get(eventIndex).addInvited(p);
		int personIndex = client.getModel().getPersons().indexOf(p);
		client.getModel().getPersons().get(personIndex).addEvent(e);
	}
	
	
	
}
