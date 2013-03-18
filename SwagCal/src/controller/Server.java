package controller;

import gui.ServerGUI;

import java.awt.EventQueue;

import net.Message;

public class Server implements Controller {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	@Override
	public void messageReceived(Message message) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	

	
}
