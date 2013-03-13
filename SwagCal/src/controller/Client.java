package controller;

import gui.ClientGUI;

import java.awt.EventQueue;

public class Client implements Controller {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void messageReceived(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub
		
	}
}
