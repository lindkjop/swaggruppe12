package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controller.Controller;

public class Group implements Databaseable  {
	private int id;
	private String groupName;
	private ArrayList<Person> members;
	private ArrayList<Event> events;
	private PropertyChangeSupport pcs;
	private Controller contr;
	private Map<String, String> arguments;
	
	
	//Setter propertychange listener
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	//Setter kontroller
	public void setController(Controller c){
		this.contr = c;
	}
	
	//GET & SET
	public ArrayList<Person> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Person> members) {
		this.members = members;
	}
	public void addMembmer(Person member) {
		this.members.add(member);
	}
	public void removeMember(Person member) {
		this.members.remove(member);
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void addEvent(Event event) {
		this.events.add(event);
	}
	
	public int getID() {
		return this.id;
	}
	
	public Group(int id, String groupName) {
		this.id = id;
		this.groupName = groupName;
	}

	@Override
	public Map getArguments() {
		// TODO Auto-generated method stub
		return this.arguments;
	}

	@Override
	public void createArguments() {
	arguments = new HashMap<String, String>();
	arguments.put("GroupsID", Integer.toString(id));
	arguments.put("groupName", groupName);
	}
	
	
}
