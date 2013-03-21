package controller;



/**
 * Interface som definerer metodene som m� implemeteres av klasser som skal fungere som en Controller.
 *
 */

public interface Controller {
	
//	Metode som kalles n�r en beskjed er mottatt i en connection. Meldingen videresendes til Controller-objektet ved et kall til denne metoden
//	med den aktuelle beskjeden som argument.
	public void messageReceived(String message);
	
//	Metode kontrolleren kan bruke for � sende informasjon til alle aktive connections.
	public void sendMessage(String message);
	
	
}
