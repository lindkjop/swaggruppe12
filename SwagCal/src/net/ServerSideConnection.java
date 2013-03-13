package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import controller.Controller;

public class ServerSideConnection {
	private String serverAdress;
	private int serverPort;
	private ServerSocket serverSocket;
	private Controller serverController;
	
	public ServerSideConnection(String serverAdress, int serverPort, Controller serverController) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		
		try 
		{	
			serverSocket = new ServerSocket(this.serverPort,50,InetAddress.getByName(this.serverAdress));
			System.out.println("WAITING FOR CONNECTIONS ON "+this.serverAdress+":"+this.serverPort);
			
			while (true) {
				new ServerThread(serverSocket.accept(), serverController).start();		
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerSideConnection("127.0.0.1", 7899);
	}
}
