package net;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import controller.Controller;


public class ClientSideConnection {

	private String serverAdress;
	private int serverPort;
	private Socket clientSocket;
	private PrintWriter toServer;
	private Controller clientController;
	 
	public ClientSideConnection(String serverAdress, int serverPort, Controller clientController) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		this.clientController = clientController;
		
		try {
			clientSocket = new Socket(InetAddress.getByName(this.serverAdress),this.serverPort);
			System.out.println("CONNECTED TO SERVER");
			toServer = new PrintWriter(clientSocket.getOutputStream(), true);
			new ListenThread(clientSocket, this.clientController).start();
		
		}	
		catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	//send til server
	public void send(String message) {
		toServer.println(message);
	}
	
	//steng connection
	public void disconnect() {
		
	}
		
}
