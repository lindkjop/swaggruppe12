package net.test;

import net.Capsule;
import net.ClientSideConnection;

public class ClientControllerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerTester clientController = new ControllerTester("ClientController");
		ClientSideConnection cConn = new ClientSideConnection("127.0.0.1", 7899, clientController);
		Capsule cap = new Capsule("Group", "INSERT");
		String toSend = cap.pack();
		System.out.println(toSend);
		cConn.send(toSend);
	}

}
