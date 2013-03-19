package db;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import net.Capsule;

import com.google.gson.Gson;


public class DatabaseFactory {
	Gson gSonObject = new Gson();	
	Capsule capsuleObject;
	String className;
	String conditions;
	String type;
	String operation;
	Object traveler;
	
	
	
	
	
	public DatabaseFactory(String objectString) {

	
	capsuleObject = gSonObject.fromJson(objectString, Capsule.class);
	className = capsuleObject.getClassName();
	conditions = capsuleObject.getCondition();
	type = capsuleObject.getType();
	operation = capsuleObject.getOperation();
	
	}
	
	public void extractObjectFromCapsule() {
	Object o = capsuleObject.getSendObject();
	
	if(className.equals("Person")) {
		Person p = gSonObject.fromJson(o.toString(), Person.class);
		System.out.println(o.toString());
		System.out.println(p.getNavn());
		
	}
	
	
	
	}
	
	
	
	
	public String toString() {
		return ("This capsule is a " + type + " command" +
				"\nIt contains the operation " + operation +
				"\nand has the conditions: " + conditions + "." +
				"\nIt contains a " + className + "Class object");
	}
	
	
	public String generateQuery() {
		return "FAAAAAILED!!";
	
		
		
	}
	

}


