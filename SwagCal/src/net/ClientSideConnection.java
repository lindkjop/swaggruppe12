package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import controller.Controller;


public class ClientSideConnection {

	private String serverAdress;
	private int serverPort;
	private Socket clientSocket;
	private PrintWriter toServer;
	private BufferedReader fromServer;
	private ArrayList<String> incomingQueue;
	private BufferedReader inFromUser;
	private Controller clientController;
	
	public ClientSideConnection(String serverAdress, int serverPort, Controller clientController) {
		this.serverAdress = serverAdress;
		this.serverPort = serverPort;
		this.clientController = clientController;
		
		try {
			clientSocket = new Socket(InetAddress.getByName(this.serverAdress),this.serverPort);
			System.out.println("CONNECTED TO SERVER");
//			fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			toServer = new PrintWriter(clientSocket.getOutputStream(), true);
//			inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			
			new ClientThread(clientSocket, clientController).start();
		
//				//respons fra server
//				String responseFromServer = fromServer.readLine();
//				//print respons fra server
//				System.out.println(responseFromServer);
			
		}	
		catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void send(String message) {
		//send til server
		toServer.println(message);
	}
		
//	public static void main(String[] args) {
//		ClientSideConnection a = new ClientSideConnection("127.0.0.1", 7899);
//		try {
//			a.send(a.inFromUser.readLine());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
