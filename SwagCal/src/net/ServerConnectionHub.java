package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;

import controller.Controller;

public class ServerConnectionHub {
	private String serverAdress;
	private int serverPort;
	private ServerSocket serverSocket;
	private Controller serverController;
	private ArrayList<ServerSideConnection> connectedClients;
	private PrintWriter toClient;
	
	public ServerConnectionHub(String serverAdress, int serverPort, Controller serverController) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		this.connectedClients = new ArrayList<ServerSideConnection>();
		this.serverController = serverController;
		
		try {	

			serverSocket = new ServerSocket(this.serverPort,50);

			System.out.println("WAITING FOR CONNECTIONS ON "+this.serverAdress+":"+this.serverPort);
			
			while (true) {
				ServerSideConnection newClient = new ServerSideConnection(serverSocket.accept(), this.serverController, this);
				connectedClients.add(newClient);
				newClient.start();
				newClient.send("Connection successful, server is listening");
				System.out.println("New client connected, current client count: "+connectedClients.size());
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendToAll(String message) {
		for (ServerSideConnection client : connectedClients) {
				client.send(message);		
		}
	}
	
	public void removeConnectedClient(ServerSideConnection client) {
		connectedClients.remove(client);
	}
}
