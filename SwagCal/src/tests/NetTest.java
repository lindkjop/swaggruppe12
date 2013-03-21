package tests;

import org.junit.Test;
import static org.junit.Assert.*;


import net.test.ClientControllerTester;
import net.test.ServerControllerTester;

public class NetTest {

	@Test
	public void test() {
		testNet();
	}
		
	public void testNet() {
		ServerControllerTester sCtrl = new ServerControllerTester();
		ClientControllerTester cCtrl = new ClientControllerTester();
		
		sCtrl.start();
		cCtrl.start();
		
		String sentFromClient = "testMessage";
		cCtrl.cConn.send(sentFromClient);
		String receivedAtServer = sCtrl.serverController.getReceived();
		System.out.println(receivedAtServer);
		assertEquals(sentFromClient, receivedAtServer);
	}
	
}
