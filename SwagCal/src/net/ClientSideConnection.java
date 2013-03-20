package net;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import controller.Controller;


public class ClientSideConnection implements Connection {

/**
* Klasse som representerer forbindelse til serveren.
* Lytter etter mottatte meldinger via en lyttetråd, og kan sende meldinger vha send-metoden.
*/
	
	private String serverAdress;
	private int serverPort;
	private Socket clientSocket;
	private PrintWriter toServer;
	private Controller clientController;
	private ListenThread listener;
	 
//	Konstruktør, tar imot adressen og portnummeret til serveren man vil koble seg til (serverAdress, serverPort), samt referanse til den ansvarlige kontrolleren.
	public ClientSideConnection(String serverAdress, int serverPort, Controller clientController) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		this.clientController = clientController;
		
		try {
			clientSocket = new Socket(InetAddress.getByName(this.serverAdress),this.serverPort);
			System.out.println("CONNECTED TO SERVER");
			toServer = new PrintWriter(clientSocket.getOutputStream(), true);
			listener = new ListenThread(clientSocket, this.clientController, this);
			listener.start();
		
		}	
		catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	//Metode for å sende meldinger til serveren.
	public void send(String message) {
		toServer.println(message);
	}
	
	//Metode for å disconnecte fra server.
	public void disconnect() {
		send("DISCONNECT_MESSAGE");
		try {
			listener.getReader().close();
			listener.interrupt();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
