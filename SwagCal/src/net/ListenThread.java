package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.Controller;

/**
 * Klasse som hele tiden lytter på meldinger fra klienten/serveren på andre siden av socketen.
 * Mottatte meldinger sendes videre til den ansvarlige kontrolleren ved hjelp av et kall til
 * messageReceived(String message) i det respektive objektet.
 *
 */

public class ListenThread extends Thread {
	private Socket socket;
	private BufferedReader fromConnection;
	private Controller controller;
	private Connection connection;
    
//	Konstruktør, tar inn socketen tråden skal lytte på, den ansvarlige controlleren samt connectionen den tilhører.
	public ListenThread(Socket socket, Controller controller, Connection connection) {
		super("ListenThread");
		this.socket = socket;
		this.controller = controller;
		this.connection = connection;
	}
	
//	Metode som kalles når tråden starter, lytter hele tiden etter meldinger sendt fra andre siden av socketen.
//	Når det mottas en melding skjer en av to ting: hvis meldingen er en disconnect-beskjed frakobles den
//	tilhørende connectionen. Ellers videresendes meldingen til kontrolleren via messageReceived-kallet.
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
	
//	Metode som sjekker om en melding er en beskjed om å disconnecte.
	private boolean isDisconnect(String s) {
		return (s == null || s.equals("DISC"));
		
	}
	
	public BufferedReader getReader() {
		return fromConnection;
	}
	
} 
