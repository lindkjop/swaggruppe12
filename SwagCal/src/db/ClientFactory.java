package db;

import model.Event;
import model.Notification;
import model.Person;
import net.Capsule;

public class ClientFactory {

	public Capsule personAddedtoEvent(Person p, Event e) {
		return null;
	}
	
	public Capsule personRemovedFromEvent(Person p, Event e) {
		return null;
	}
	
	public Capsule eventInfoChanged(Event event) {
		Capsule cap = new Capsule("DATABASE", "UPDATE", "Event", true);
		cap.setCondition("eventID="+event.getID());
		cap.setSendObject(event);
		return cap;
	}
	
	public Capsule eventAdded(Event event) {
		Capsule cap = new Capsule("DATABASE", "INSERT", "Event", true);
		cap.setSendObject(event);
		return cap;
	}
	
	public Capsule eventDeleted(Event event) {
		Capsule cap = new Capsule("DATABASE", "DELETE", "Event", true);
		cap. setCondition("eventID="+event.getID());
		cap.setSendObject(event);
		return cap;
	}
	
	public Capsule alarmChanged(Notification notification) {
		Capsule cap = new Capsule("DATABASE", "UPDATE", "Notification", true);
		cap.setCondition("notificationID="+notification.getID());
		cap.setSendObject(notification);
		return cap;
	}
	
}
