package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import controller.Controller;

/**
 * Klasse som representerer en forbindelse til klienten på andre siden av socketen.
 * Lytter etter mottatte meldinger via en lyttetråd, og kan sende meldinger vha send-metoden.
 */

public class ServerSideConnection extends Thread implements Connection{
	private Socket socket;
	private BufferedReader fromClient;
	private PrintWriter toClient;
	private Controller controller;
	private ServerConnectionHub hub;
	private ListenThread listener;

//	Konstruktør, tar imot den aktuelle socketen det kommuniseres gjennom, samt referanser til Controller-objektet og ServerConnectionHub-objektet
//	som styrer de forskjellieg forbindelsene.
    public ServerSideConnection(Socket socket, Controller serverController, ServerConnectionHub hub) {
    	super("ServerSideConnectionThread");
    	this.socket = socket;
    	this.controller = serverController;
    	this.hub = hub;
    }

//    Metoden som kalles når tråden starter, oppretter lyttetråd
    public void run() {

    	try {
    		toClient = new PrintWriter(socket.getOutputStream(),true);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	listener = new ListenThread(socket, controller, this);
    	listener.start();
	}
    
//    Metode for å sende meldinger til klienten på andre siden av socketen.
    public void send(String message) {
    	if (toClient == null) {
    		try {
        		toClient = new PrintWriter(socket.getOutputStream(),true);
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
    	}
    	toClient.println(message);
    }

//    Metode for å rydde opp etter en klient har koblet seg fra.
	@Override
	public void disconnect() {
		try {
			listener.getReader().close();
			listener.interrupt();
			hub.removeConnectedClient(this);
			socket.close();
			this.interrupt();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
