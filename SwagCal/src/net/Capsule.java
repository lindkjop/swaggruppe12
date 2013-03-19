package net;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Event;
import model.Group;
import model.Notification;
import model.Person;
import model.Room;

import com.google.gson.Gson;

/**
 * 
 * @author Daniel
 * 
 */

public class Capsule {

	/**
	 * type - type of capsule. Can be either "MESSAGE" or "DATABASE" operation -
	 * Operation that can be performed. For "DATABASE" it can be either
	 * "SELECT", "DELETE", "INSERT" or "UPDATE". for "MESSAGE" it can be...
	 */

	String type;
	String operation;
	String classname;
	Boolean doReturnObject;
	String condition;
	Object sendObject;
	Map values = new HashMap<String, String>();

	Gson capsulePackage;

	public String pack() {
		Gson packagedObject = new Gson();
		return packagedObject.toJson(this);

	}

	public Capsule(String type, String operation, String classname,
			Boolean doReturnObject) {

		this.type = type;
		this.operation = operation;
		this.classname = classname;
		this.doReturnObject = doReturnObject;
	}

	public Capsule(String type, String operation) {
		this.type = type;
		this.operation = operation;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getOperation() {
		return this.operation;
	}
	
	public String getCondition() {
		return this.condition;
	}
	
	public Boolean doReturnObject() {
		return this.doReturnObject;
	}
	
	public String getClassName() {
		return this.classname;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
		
	}

	public void setSendObject(Object sendObject) {
		this.sendObject = sendObject;
	}

	public Object getSendObject() {
		return sendObject;
	}
}
