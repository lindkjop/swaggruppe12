package net.backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import controller.Controller;

public class OLDClientThread extends Thread{
	private Socket socket;
	private BufferedReader fromServer;
	private Controller controller;

    public OLDClientThread(Socket socket, Controller clientController) {
    	super("ClientThread");
    	this.socket = socket;
    	this.controller = clientController;
    }

    public void run() {

		try {
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("WAITING FOR MESSAGE FROM SERVER");
			while (true) {
				Message stringFromServer = fromServer.readLine();
				controller.messageReceived(stringFromServer);
//				System.out.println("MESSAGE FROM SERVER: "+StringFromServer);
				}
			
		    }
		catch (IOException e) {
			e.printStackTrace();
			}
	}
}
