package db;

import java.util.HashMap;
import java.util.Map;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;
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
	Map<String,String> arguments;
	
	
	
	
	
	public DatabaseFactory(String objectString) {

	
	capsuleObject = gSonObject.fromJson(objectString, Capsule.class);
	className = capsuleObject.getClassName();
	conditions = capsuleObject.getCondition();
	type = capsuleObject.getType();
	operation = capsuleObject.getOperation();
	
	}
	
	public void extractArgumentsFromObject() {
	Object o = capsuleObject.getSendObject();
	
	if(className.equals("Person")) {
		Person p = gSonObject.fromJson(o.toString(), Person.class);
		arguments = p.getArguments();
		}
	else if(className.equals("Event")) {
		Event p = gSonObject.fromJson(o.toString(), Event.class);
		arguments = p.getArguments();	
	}
	else if(className.equals("Group")) {
		Group p = gSonObject.fromJson(o.toString(), Group.class);
		arguments = p.getArguments();
	}
	
	else if(className.equals("Notification")) {
		Notification p = gSonObject.fromJson(o.toString(), Notification.class);
		arguments = p.getArguments();
	}
	else if(className.equals("Room")) {
		Room p = gSonObject.fromJson(o.toString(), Room.class);
		arguments = p.getArguments();
	}
	
	System.out.println("Blob!");
	System.out.println(arguments);
	
	}
	
	
	
	public String toString() {
		return ("This capsule is a " + type + " command" +
				"\nIt contains the operation " + operation +
				"\nand has the conditions: " + conditions + "." +
				"\nIt contains a " + className + "Class object");
	}
	

}


