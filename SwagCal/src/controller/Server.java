package controller;

import gui.ServerGUI;

import java.awt.EventQueue;

import tools.dateTime;

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
	public void messageReceived(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub
		
	}

	
}
