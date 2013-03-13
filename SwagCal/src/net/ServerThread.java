package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import controller.Controller;

public class ServerThread extends Thread{
	private Socket socket;
	private BufferedReader fromClient;
	private PrintWriter toClient;
	private Controller controller;

    public ServerThread(Socket socket, Controller serverController) {
    	super("ServerThread");
    	this.socket = socket;
    	this.controller = serverController;
    }

    public void run() {

//		try {
//			fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			toClient = new PrintWriter(socket.getOutputStream(),true);
//			System.out.println("WAITING FOR MESSAGE FROM CLIENT");
//			while (true) {
//				String stringFromClient = fromClient.readLine();
//				controller.messageReceived(stringFromClient);
////				System.out.println("MESSAGE FROM CLIENT: "+stringFromClient);
//				}
//			
//		    }
    	
//		catch (IOException e) {
//			e.printStackTrace();
//			}
    	new ListenThread(socket, controller).start();
	}
    
    public void send(String message) {
    	if (toClient == null) {
    		try {
    			toClient = new PrintWriter(socket.getOutputStream(),true);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	toClient.println(message);
    }
}
