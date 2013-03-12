package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
	private Socket socket;
	private BufferedReader fromServer;

    public ClientThread(Socket socket) {
    	super("ClientThread");
    	this.socket = socket;
    }

    public void run() {

		try {
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("WAITING FOR MESSAGE FROM SERVER");
			while (true) {
				String StringFromServer = fromServer.readLine();
				System.out.println("MESSAGE FROM SERVER: "+StringFromServer);
				}
			
		    }
		catch (IOException e) {
			e.printStackTrace();
			}
	}
}
