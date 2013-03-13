package net;

import controller.Controller;

public class ControllerTester implements Controller {
	private String name;
	public ControllerTester(String name) {
		this.name = name;
	}
	
	@Override
	public void messageReceived(String message) {
		System.out.println("FROM "+name+": "+message);
		
	}

	@Override
	public void send(String message) {
		
		
	}

}
