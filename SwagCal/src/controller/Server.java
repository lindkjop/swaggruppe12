package controller;

import gui.ServerGUI;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import net.Message;

import com.google.gson.Gson;

import db.DBConnection;

import net.Message;

public class Server implements Controller {
	private DBConnection db;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Server(Properties properties) throws ClassNotFoundException, SQLException
	{
		db = new DBConnection(properties);
	}

	public Server(String filename) throws ClassNotFoundException, IOException, SQLException
	{
		db = new DBConnection(filename);
	}	
	
	@Override
	public void messageReceived(Message message) {
<<<<<<< HEAD
		String className = message.getClassName();
		String queryEffect = message.getQuery();
		Boolean isUpdate = message.isUpdate();
		
		
		
	}

	@Override
	public void send(String message) {
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
=======
>>>>>>> 0104f2b4b0bc45b9ad6ed6bcbec6df7e3e5ad20e
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
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
	
	public 
=======
	
>>>>>>> 0104f2b4b0bc45b9ad6ed6bcbec6df7e3e5ad20e

	
}
