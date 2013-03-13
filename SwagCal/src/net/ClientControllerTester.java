package net;

public class ClientControllerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerTester clientController = new ControllerTester("ClientController");
		ClientSideConnection cConn = new ClientSideConnection("127.0.0.1", 7899, clientController);
		cConn.send("HELO");
	}

}
