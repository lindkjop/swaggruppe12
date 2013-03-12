package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	private BufferedReader fromClient;
	private PrintWriter toClient;

    public ServerThread(Socket socket) {
    	super("ServerThread");
    	this.socket = socket;
    }

    public void run() {

		try {
			fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			toClient = new PrintWriter(socket.getOutputStream(),true);
			System.out.println("WAITING FOR MESSAGE FROM CLIENT");
			while (true) {
				String StringFromClient = fromClient.readLine();
				System.out.println("MESSAGE FROM CLIENT: "+StringFromClient);
				toClient.println("MESSAGE RECEIVED ON SERVER: "+StringFromClient);
				}
			
		    }
		catch (IOException e) {
			e.printStackTrace();
			}
	}
}
