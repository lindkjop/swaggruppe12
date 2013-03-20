package net;

public interface Connection {
/**
*Interface som definerer metodene en connection må implementere.
*/
	
//	Metode for å koble seg fra den tilkoblede serveren/klienten.
	public void disconnect();
	
//	Metode for å sende meldinger til den tilkoblede serveren/klienten.
	public void send(String message);
}
