package gui.actions;

import model.Person;
import controller.Client;
import controller.Controller;

public class LoggOn {
	private Person user;
	private boolean sucsess;
	
	
	public LoggOn(String userName, String password, Person user, Client c){
		sucsess = false;
		for (Person p: c.getModel().getPersons()){
			System.out.println(password);
			System.out.println(p.getPassword());
			if (p.getPassword().equals(password.toString()) && p.getUserName().equals(userName)){
				sucsess = true;
			}
		}
	}
	
	public boolean getSucsess(){
		return true;
	}
	


}
