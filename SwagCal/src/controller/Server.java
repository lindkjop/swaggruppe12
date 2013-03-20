package controller;

import gui.ServerGUI;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import net.ServerConnectionHub;

import com.google.gson.Gson;
import net.ServerConnectionHub;


import db.Factory;

import net.backup.Message;

public class Server implements Controller {
	private Factory factory;
	private ServerConnectionHub server;

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
	
	
	public Server() throws ClassNotFoundException, IOException, SQLException {
	factory = new Factory("./src/db/Properties.properties");
	server = new ServerConnectionHub("127.0.0.1",7899, this);
	}
	
	
	@Override
	public void messageReceived(String message) {
//		String className = message.getClassName();
//		String query = message.getQuery();
//		Boolean isUpdate = message.isUpdateMessage();
//		
//		if(isUpdate) {factory.doUpdate(query);}
//		else {factory.doQuery(query);}
			
		}
	
	
	public void sendMessage(String message) {
		server.sendToAll(message);
	
		
	}
	
}
