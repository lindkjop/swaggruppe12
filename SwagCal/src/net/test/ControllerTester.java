package net.test;

import net.Message;
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
		System.out.println("RECEIVED AT "+name+". Message: "+message);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		
	}



}
