package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import controller.Controller;

public class ServerSideConnection extends Thread implements Connection{
	private Socket socket;
	private BufferedReader fromClient;
	private PrintWriter toClient;
	private Controller controller;
	private ServerConnectionHub hub;
	private ListenThread listener;

    public ServerSideConnection(Socket socket, Controller serverController, ServerConnectionHub hub) {
    	super("ServerSideConnectionThread");
    	this.socket = socket;
    	this.controller = serverController;
    }

    public void run() {

    	try {
    		toClient = new PrintWriter(socket.getOutputStream(),true);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	listener = new ListenThread(socket, controller, this);
    	listener.start();
	}
    
    public void send(String message) {
    	if (toClient == null) {
    		try {
        		toClient = new PrintWriter(socket.getOutputStream(),true);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
    	}
    	toClient.println(message);
    }

	@Override
	public void disconnect() {
		try {
			listener.getReader().close();
			listener.interrupt();
			hub.removeConnectedClient(this);
			socket.close();
			this.interrupt();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
