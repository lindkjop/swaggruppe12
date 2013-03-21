package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import tools.Stringify;

import controller.Controller;


/**
 * Klasse som representerer et m�terom.
 * Inneholder informasjon om navn, nummer og st�rrelse,
 * samt en liste over n�r rommet er booket.
 */


public class Room {

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
	
	//Konstrukt�r
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

	public Map getArguments() {
	createArguments();
	return attributes;
	
	}

//	Metode som fyller arguments-hashmappet med felter/verdier fra dette objektet.
	public void createArguments() {
		attributes = new HashMap<String,String>();
		attributes.put("roomName", Stringify.makeString(roomName));
		attributes.put("roomSize", Integer.toString(size));
		
	}
}
