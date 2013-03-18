package controller;

import gui.ClientGUI;
import gui.LoginGUI;

import java.awt.EventQueue;

import model.Model;
import model.Person;
import net.Message;

public class Client implements Controller {
	
	private Person user;
	private Client client;
	private Model model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Client();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Client(){
		//Ekstra innloggingsperson;
		Person dude = new Person(99, "Tibor", 9999999, "tibor", "kul");
		model = new Model();
		model.addPerson(dude);
		
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

	@Override
	public void messageReceived(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	
	

}
