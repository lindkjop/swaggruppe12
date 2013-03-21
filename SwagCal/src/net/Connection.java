package net;

public interface Connection {
/**
*Interface som definerer metodene en connection m� implementere.
*/
	
//	Metode for � koble seg fra den tilkoblede serveren/klienten.
	public void disconnect();
	
//	Metode for � sende meldinger til den tilkoblede serveren/klienten.
	public void send(String message);
}
