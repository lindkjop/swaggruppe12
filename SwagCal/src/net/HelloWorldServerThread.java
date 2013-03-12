package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloWorldServerThread extends Thread{
	private Socket socket = null;

    public HelloWorldServerThread(Socket socket) {
    	super("HelloWorldServerThread");
    	this.socket = socket;
    }

    public void run() {

	try {
		while(true) {
		//This is commented in the HelloWorldClient class
		InputStream clientInputStream = socket.getInputStream();
		OutputStream clientOutputStream = socket.getOutputStream();
		InputStreamReader inFromClient = new InputStreamReader(clientInputStream);
		BufferedReader StringFromClient = new BufferedReader(inFromClient);
		PrintWriter outToClient = new PrintWriter(clientOutputStream,true);
		System.out.println("WAITING FOR MESSAGE FROM CLIENT");
		
		String fromClient = StringFromClient.readLine();
		System.out.println("MESSAGE FROM CLIENT: "+fromClient);
		outToClient.println("MESSAGE RECEIVED ON SERVER: "+fromClient);
		System.out.println(socket.getLocalSocketAddress());
	    }
	}
	catch (IOException e) {
		e.printStackTrace();
		}
	}
}

