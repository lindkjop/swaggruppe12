package net;

public class ServerControllerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerTester serverController = new ControllerTester("ServerController");
		ServerSideConnection sConn = new ServerSideConnection("127.0.0.1", 7899, serverController);
		

	}

}
