package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import controller.Controller;

public class ServerSideConnection extends Thread{
	private Socket socket;
	private BufferedReader fromClient;
	private PrintWriter toClient;
	private Controller controller;

    public ServerSideConnection(Socket socket, Controller serverController) {
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
    	new ListenThread(socket, controller).start();
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
}
