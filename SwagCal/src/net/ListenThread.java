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
    
	public ListenThread(Socket socket, Controller controller) {
		super("ListenThread");
		this.socket = socket;
		this.controller = controller;
	}
	
	public void run() {

		try {
			fromConnection = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String stringFromClient = fromConnection.readLine();
				controller.messageReceived(stringFromClient);
				}
			
		    }
		catch (IOException e) {
			e.printStackTrace();
			}
	}
	
} 
