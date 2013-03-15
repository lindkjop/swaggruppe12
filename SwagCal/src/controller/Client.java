package controller;

import gui.ClientGUI;
import gui.LoginGUI;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;

public class Client implements Controller {
	
	private Person user;
	private Client client;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Client();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Client(){
		//Ekstra innloggingsperson;
		Person dude = new Person(99, "Tibor", 9999999, "tibor", "kul");
		
		LoginGUI login = new LoginGUI(user,this);
		login.setVisible(true);
	}
	

	public void setWorkFrame(){
		ClientGUI frame = new ClientGUI(user,this);
		frame.setVisible(true);
	}

	@Override
	public void connReceived(String message) {
		// TODO Auto-generated method stub
		
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
