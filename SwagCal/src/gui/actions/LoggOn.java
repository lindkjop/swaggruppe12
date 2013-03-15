package gui.actions;

import model.Person;
import controller.Controller;

public class LoggOn {
	private Person user;
	private boolean sucsess;
	
	
	public LoggOn(String userName, String password, Person user){
		this.user = user;
		this.user = new Person(1, "Anus", 99999,"anis", "GEIR");
		sucsess = true;
	}
	
	public boolean getSucsess(){
		return this.sucsess;
	}
	


}
