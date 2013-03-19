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

public class Capsule {

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

public Capsule(String type, String operation, String classname, Boolean doReturnObject) {
this.type = type;
this.operation = operation;
this.classname = classname;
this.doReturnObject = doReturnObject;
}

public Capsule(String type, String operation) {
	this.type = type;
	this.operation = operation;
}


public void setSendObject(Object sendObject) {
	this.sendObject = sendObject;
}


public Object getSendObject() {
return sendObject;

/* if(classname.equals("Person")) { l = h.fromJson(sendObject, Person.class);}
if(classname.equals("Event")) {  l = h.fromJson(sendObject, Event.class);}
if(classname.equals("Group")) { l = h.fromJson(sendObject, Group.class);}
if(classname.equals("Room")) { l = h.fromJson(sendObject, Room.class);}
if(classname.equals("Notification")) {  l = h.fromJson(sendObject, Notification.class);}
else { l = null; }
return l; */




}
}


