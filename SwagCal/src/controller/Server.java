package controller;

import gui.ServerGUI;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import net.Message;

import com.google.gson.Gson;


import db.Factory;

import net.Message;

public class Server implements Controller {
	private Factory factory;

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
	}
	
	
	@Override
	public void messageReceived(Message message) {
		String className = message.getClassName();
		String queryEffect = message.getQuery();
		Boolean isUpdate = message.isUpdateMessage();
		
		if(isUpdate) {
			
		}
		
		
		
	}
	
	public void sendMessage(Message message) {
		
	}
	
}
