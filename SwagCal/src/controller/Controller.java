package controller;

import net.Message;

public interface Controller {
	
	public void messageReceived(String message);
	
	public void sendMessage(String message);
	
	
}
