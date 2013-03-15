package net.test;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;
import controller.Controller;

public class ControllerTester implements Controller {
	private String name;
	public ControllerTester(String name) {
		this.name = name;
	}
	
	@Override
	public void messageReceived(String message) {
		System.out.println("RECEIVED AT "+name+": "+message);
		
	}

	public void send(String message) {
		
		
	}

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void personObjectReceived(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventObjectReceived(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupObjectReceived(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificationObjectReceived(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void roomObjectReceived(Room room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPersonObject(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEventObject(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendGroupObject(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendNotificationObject(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendRoomObject(Room room) {
		// TODO Auto-generated method stub
		
	}

}
