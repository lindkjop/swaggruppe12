package net.test;

import model.Person;
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
		
		
		
		Capsule cap = new Capsule("Message", "INSERT", "Person", false);
		cap.setSendObject(new Person(10, "per", 12345678, "#per", "perword"));
		String toSend = cap.pack();
		cConn.send(toSend);
		
	}

}
