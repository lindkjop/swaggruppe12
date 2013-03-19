package net;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	return this.sendObject;
}


}
