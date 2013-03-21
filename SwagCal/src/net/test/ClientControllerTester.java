package net.test;

import model.Person;
import net.Capsule;
import net.ClientSideConnection;

public class ClientControllerTester /*For testing -->*/extends Thread /*<--For testing*/{

	public ControllerTester clientController;
	public ClientSideConnection cConn;
	
	public void run() {
		clientController = new ControllerTester("ClientController");
		cConn = new ClientSideConnection("127.0.0.1", 7899, clientController);
		clientController.setConnection(cConn);
	}
}
