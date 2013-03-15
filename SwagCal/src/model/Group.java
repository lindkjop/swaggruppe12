package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import controller.Controller;

public class Group {
	private int id;
	private ArrayList<Person> members;
	private ArrayList<Group> subGroups;
	private ArrayList<Event> events;
	private PropertyChangeSupport pcs;
	private Controller contr;
	
	
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
	public ArrayList<Group> getSubGroups() {
		return subGroups;
	}
	public void setSubGroups(ArrayList<Group> subGroups) {
		this.subGroups = subGroups;
	}
	public void addSubGroup(Group subgroup) {
		this.subGroups.add(subgroup);
	}
	public void removeSubGroup(Group subGroup) {
		this.subGroups.remove(subGroup);
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void addEvent(Event event) {
		this.events.add(event);
	}
	
	public Group(int id) {
		this.id = id;
	}
	
	
}
