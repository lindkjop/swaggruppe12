package controller;

import net.Message;

public interface Controller {
	
	public void messageReceived(Message message);
	
	public void sendMessage(Message message);
	
	
}
