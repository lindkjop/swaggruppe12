package net.test;

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

	@Override
	public void send(String message) {
		
		
	}

}
