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
		String className = message.getClassName();
		String queryEffect = message.getQuery();
		Boolean isUpdate = message.isUpdate();
		
		
		
	}
	
	public void sendMessage(Message message) {
		
	}
	
}
