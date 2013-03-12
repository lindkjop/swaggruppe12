package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerSideConnection {
	private String serverAdress;
	private int serverPort;
	private ServerSocket serverSocket;
	
	public ServerSideConnection(String serverAdress, int serverPort) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		
		try 
		{	
			serverSocket = new ServerSocket(this.serverPort,50,InetAddress.getByName(this.serverAdress));
			System.out.println("WAITING FOR CONNECTIONS ON "+this.serverAdress+":"+this.serverPort);
			
			while (true) {
				new ServerThread(serverSocket.accept()).start();		
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
