package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.Controller;

public class ListenThread extends Thread {
	private Socket socket;
	private BufferedReader fromConnection;
	private Controller controller;
	private Connection connection;
    
	public ListenThread(Socket socket, Controller controller, Connection connection) {
		super("ListenThread");
		this.socket = socket;
		this.controller = controller;
		this.connection = connection;
	}
	
	public void run() {

		try {
			fromConnection = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String stringFromConnection = fromConnection.readLine();
				if (isDisconnect(stringFromConnection)) {
					connection.disconnect();
				}
				controller.messageReceived(stringFromConnection);
				}
			
		    }
		catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	public BufferedReader getReader() {
		return fromConnection;
	}
	
	private boolean isDisconnect(String s) {
		return false;
	}
} 
