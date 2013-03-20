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
	String values;
	String keys;
	String pair;
	
	String query;
	
	
	
	
	public DatabaseFactory(String objectString) {
		
	
	capsuleObject = gSonObject.fromJson(objectString, Capsule.class);
	className = capsuleObject.getClassName();
	conditions = capsuleObject.getCondition();
	type = capsuleObject.getType();
	operation = capsuleObject.getOperation();
	
	}
	
	public void extractArgumentsFromObject() {
	Object o = capsuleObject.getSendObject();
	System.out.println(className);
	
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
	
	constructArray();
	
	}
	
	
	public void constructArray() {
		pair = "";
		
		values="";
		keys="";
		
		int i = 0;
		for (Map.Entry<String, String> entry : arguments.entrySet()) {
		keys += ", " +  entry.getKey(); 
		values += ", " + entry.getValue();
		pair += ", '" + entry.getKey() + "'" + "= " + entry.getValue();

		
		}
		
		keys = keys.substring(2);
		values = values.substring(2);
		pair = pair.substring(2);
		
		System.out.println(pair);
		System.out.println(values);
		System.out.println(keys);
		
		generateQuery();

	}
	
	public String generateQuery() {
		
		System.out.println("Beginning query!");
	
	
	
	if(operation.equals("DELETE") || operation.equals("SELECT")) {
	query = String.format("FROM %s %s", className, operation);
	System.out.println(query);	
	}
	
	else if (operation.equals("INSERT")) {
	query = String.format("INSERT INTO %s (%s) VALUES (%s)" ,className,keys,values);
	System.out.println(query);		
		
	}
	
	else if (operation.equals("UPDATE")) {
	query = String.format("UPDATE %s SET %s WHERE %s", className, pair, conditions);
	}
	
	else if (operation.equals("SELECT")) {
	query = String.format("SELECT * FROM %s WHERE %s", className, conditions);
	
	}
	
	System.out.println(query);
	return query;
	
	
		
		

	}


	public String toString() {
		return ("This capsule is a " + type + " command" +
				"\nIt contains the operation " + operation +
				"\nand has the conditions: " + conditions + "." +
				"\nIt contains a " + className + "Class object");
	}
	

}


