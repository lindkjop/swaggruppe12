package net.test;

import net.ServerConnectionHub;

public class ServerControllerTester /*For testing -->*/extends Thread /*<--For testing*/{

	public ControllerTester serverController;
	public ServerConnectionHub sConn;
	
	public void run() {
		
		serverController = new ControllerTester("ServerController");
		sConn = new ServerConnectionHub(7899, serverController);
		

	}

}
