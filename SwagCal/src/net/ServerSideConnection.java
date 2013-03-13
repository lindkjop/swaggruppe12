package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import controller.Controller;

public class ServerSideConnection {
	private String serverAdress;
	private int serverPort;
	private ServerSocket serverSocket;
	private Controller serverController;
	public ArrayList<ServerThread> connectedClients;
	private PrintWriter toClient;
	
	public ServerSideConnection(String serverAdress, int serverPort, Controller serverController) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		this.connectedClients = new ArrayList<ServerThread>();
		
		try 
		{	
			serverSocket = new ServerSocket(this.serverPort,50,InetAddress.getByName(this.serverAdress));
			System.out.println("WAITING FOR CONNECTIONS ON "+this.serverAdress+":"+this.serverPort);
			
			while (true) {
				ServerThread newClient = new ServerThread(serverSocket.accept(), serverController);
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
		for (ServerThread client : connectedClients) {
				client.send(message);		
		}
		
	}
//	public static void main(String[] args) {
//		
//		new ServerSideConnection("127.0.0.1", 7899);
//	}
}
