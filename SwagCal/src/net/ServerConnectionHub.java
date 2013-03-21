package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;

import controller.Controller;

/**
 * Klasse som s�rger for og tar seg av tilkobling til serveren fra klienter.
 * Lytter p� tilkoblinger, og for hver klient som kobler seg til opprettes 
 * det en egen ServerSideConnection som tar seg av videre kommunikasjon med akkurat den
 * klienten. Tilkoblede klienter legges til i en liste, med mulighet for � sende
 * meldinger til alle tilkoblede klienter. 
 *
 */

public class ServerConnectionHub {
	private int serverPort;
	private ServerSocket serverSocket;
	private Controller serverController;
	private ArrayList<ServerSideConnection> connectedClients;
	private PrintWriter toClient;
	
//	Konstrukt�r, tar imot port det skal lyttes p� (serverPort) og controller som "eier" ServerConnectionHub-objektet.
	public ServerConnectionHub(int serverPort, Controller serverController) {
		this.serverPort = serverPort;
		this.connectedClients = new ArrayList<ServerSideConnection>();
		this.serverController = serverController;
		
		try {	

			serverSocket = new ServerSocket(this.serverPort,50);

			System.out.println("WAITING FOR CONNECTIONS ON PORT "+this.serverPort);
			
//			L�kke som tar imot connection, legger til klient i liste og starter ny serverSideConnection-tr�d.
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

//	Metode for � sende en melding til alle tilkoblede klienter.
	public void sendToAll(String message) {
		for (ServerSideConnection client : connectedClients) {
				client.send(message);		
		}
	}
	
//	Metode som fjerner connections, brukes n�r klienter frakobler seg.
	public void removeConnectedClient(ServerSideConnection client) {
		connectedClients.remove(client);
	}
}
