package controller;

import gui.ClientGUI;
import gui.LoginGUI;

import java.awt.EventQueue;

import model.Model;
import model.Person;

public class Client {
	
	private Person user;
	private Client client;
	private Model model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model m = new Model();
					new Client(m);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Client(Model model){
		this.model =model;
		LoginGUI login = new LoginGUI(user,this);
		login.setVisible(true);
	}
	
	public Model getModel(){
		return model;
	}
	
	public void setWorkFrame(){
		ClientGUI frame = new ClientGUI(user,this);
		frame.setVisible(true);
	}
	

}
