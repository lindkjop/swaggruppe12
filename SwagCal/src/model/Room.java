package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import tools.Stringify;

import controller.Controller;

public class Room implements Databaseable {
	private int roomNumber;
	private String roomName;
	private int size;
	private ArrayList<Date> booked;
	private PropertyChangeSupport pcs;
	private Controller contr;
	private Map<String, String> attributes;
	
	//Setter propertychange listener
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	//Setter kontroller
	public void setController(Controller c){
		this.contr = c;
	}
	
	//Konstruktør
	public Room(int roomNumber, String roomName, int size) {
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.size = size;
	}
	
	//GET & SET
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public Map getArguments() {
	createArguments();
	return attributes;
	
	}

	@Override
	public void createArguments() {
		attributes = new HashMap<String,String>();
		attributes.put("roomName", Stringify.makeString(roomName));
		attributes.put("roomSize", Integer.toString(size));
		
	}
	

	
	
	
}
