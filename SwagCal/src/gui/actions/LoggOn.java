package gui.actions;

import model.Person;
import controller.Client;
import controller.Controller;

public class LoggOn {
	private Person user;
	private boolean sucsess;
	
	
	public LoggOn(String userName, char[] password, Person user, Client c){
		sucsess = false;
		for (Person p: c.getModel().getPersons()){
			if (p.getPassword().equals(password) && p.getUserName().equals(userName)){
				sucsess = true;
			}
		}
	}
	
	public boolean getSucsess(){
		return this.sucsess;
	}
	


}
