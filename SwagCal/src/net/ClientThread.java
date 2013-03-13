package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import controller.Controller;

public class ClientThread extends Thread{
	private Socket socket;
	private BufferedReader fromServer;
	private Controller controller;

    public ClientThread(Socket socket, Controller clientController) {
    	super("ClientThread");
    	this.socket = socket;
    }

    public void run() {

		try {
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("WAITING FOR MESSAGE FROM SERVER");
			while (true) {
				String StringFromServer = fromServer.readLine();
				controller.messageReceived(StringFromServer);
//				System.out.println("MESSAGE FROM SERVER: "+StringFromServer);
				}
			
		    }
		catch (IOException e) {
			e.printStackTrace();
			}
	}
}
