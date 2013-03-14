package net.backup;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import net.ServerSideConnection;

import controller.Controller;

public class OLDServerSideConnection {
	private String serverAdress;
	private int serverPort;
	private ServerSocket serverSocket;
	private Controller serverController;
	public ArrayList<ServerSideConnection> connectedClients;
	private PrintWriter toClient;
	
	public OLDServerSideConnection(String serverAdress, int serverPort, Controller serverController) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		this.connectedClients = new ArrayList<ServerSideConnection>();
		
		try 
		{	
			serverSocket = new ServerSocket(this.serverPort,50,InetAddress.getByName(this.serverAdress));
			System.out.println("WAITING FOR CONNECTIONS ON "+this.serverAdress+":"+this.serverPort);
			
			while (true) {
				ServerSideConnection newClient = new ServerSideConnection(serverSocket.accept(), serverController);
				connectedClients.add(newClient);
				newClient.start();
				int last = connectedClients.size();
				System.out.println(last);
				System.out.println(connectedClients.get(last-1));
				if (connectedClients.size() == 3) {
					sendToAll("HELO FROM SERVER");
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void sendToAll(String message) {
		for (ServerSideConnection client : connectedClients) {
				client.send(message);		
		}
		
	}
//	public static void main(String[] args) {
//		
//		new ServerSideConnection("127.0.0.1", 7899);
//	}
}
