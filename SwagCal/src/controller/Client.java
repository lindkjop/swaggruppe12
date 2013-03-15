package controller;

import gui.ClientGUI;
import gui.LoginGUI;
import gui.ServerGUI;

import java.awt.EventQueue;

public class Client implements Controller {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					ServerGUI login = new ServerGUI();
					frame.setVisible(false);
					login.setVisible(true);
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
