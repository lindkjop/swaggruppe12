package net.test;

import net.ServerConnectionHub;

public class ServerControllerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerTester serverController = new ControllerTester("ServerController");
		ServerConnectionHub sConn = new ServerConnectionHub(7899, serverController);
		

	}

}
