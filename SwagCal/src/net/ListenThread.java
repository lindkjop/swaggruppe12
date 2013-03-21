package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.Controller;

/**
 * Klasse som hele tiden lytter p� meldinger fra klienten/serveren p� andre siden av socketen.
 * Mottatte meldinger sendes videre til den ansvarlige kontrolleren ved hjelp av et kall til
 * messageReceived(String message) i det respektive objektet.
 *
 */

public class ListenThread extends Thread {
	private Socket socket;
	private BufferedReader fromConnection;
	private Controller controller;
	private Connection connection;
    
//	Konstrukt�r, tar inn socketen tr�den skal lytte p�, den ansvarlige controlleren samt connectionen den tilh�rer.
	public ListenThread(Socket socket, Controller controller, Connection connection) {
		super("ListenThread");
		this.socket = socket;
		this.controller = controller;
		this.connection = connection;
	}
	
//	Metode som kalles n�r tr�den starter, lytter hele tiden etter meldinger sendt fra andre siden av socketen.
//	N�r det mottas en melding skjer en av to ting: hvis meldingen er en disconnect-beskjed frakobles den
//	tilh�rende connectionen. Ellers videresendes meldingen til kontrolleren via messageReceived-kallet.
	public void run() {

		try {
			fromConnection = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String stringFromConnection = fromConnection.readLine();
				if (isDisconnect(stringFromConnection)) {
					connection.disconnect();
					break;
				}
				controller.messageReceived(stringFromConnection);
				}
			
		    }
		catch (IOException e) {
			e.printStackTrace();
			}
	}
	
//	Metode som sjekker om en melding er en beskjed om � disconnecte.
	private boolean isDisconnect(String s) {
		return (s == null || s.equals("DISC"));
		
	}
	
	public BufferedReader getReader() {
		return fromConnection;
	}
	
} 
