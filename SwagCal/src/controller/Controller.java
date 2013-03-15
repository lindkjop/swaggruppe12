package controller;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;

public interface Controller {
	
	public void connReceived(String message);
	
	public void sendMessage(String message);
	
	public void personObjectReceived(Person person);
	
	public void eventObjectReceived(Event event) ;
	
	public void groupObjectReceived(Group group);
	
	public void notificationObjectReceived(Notification notification);
	
	public void roomObjectReceived(Room room);
	
	public void sendPersonObject(Person person);
	
	public void sendEventObject(Event event);
	
	public void sendGroupObject(Group group);
	
	public void sendNotificationObject(Notification notification);
	
	public void sendRoomObject(Room room);
}
