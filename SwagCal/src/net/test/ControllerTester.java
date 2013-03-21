package net.test;

import net.Connection;
import controller.Controller;

public class ControllerTester implements Controller {
	private String name;
	private String received;
	private Connection connection;
	
	public ControllerTester(String name) {
		this.name = name;
	}
	
	@Override
	public void messageReceived(String message) {
//		System.out.println("RECEIVED AT "+name+". Message: "+message);
		received = message;
	}

	@Override
	public void sendMessage(String message) {
		
		
	}

	public String getReceived() {
		return received;
	}

	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
