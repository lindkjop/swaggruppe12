package net.test;

import net.ClientSideConnection;

public class ClientControllerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerTester clientController = new ControllerTester("ClientController");
		ClientSideConnection cConn = new ClientSideConnection("78.91.29.48", 7899, clientController);
		cConn.send("HELO");
	}

}
