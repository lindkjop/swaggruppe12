package controller;

import gui.ClientGUI;
import gui.ServerGUI;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import model.Event;
import model.Person;
import model.Room;

import db.Factory;

import tools.dateTime;



public class Testing {	
	//Eksempel på strukturert måte å teste på.
	
	public static void main(String[] args) {
		new Testing();
		
	}


	public Testing() {
		testDateTime();
		testDataBase();

	}
	
	
	private void testDateTime(){
		dateTime temp1= new dateTime(0,20,18,12,03,2013);
		dateTime temp2 = new dateTime(30,20,19,12,03,2013);
		System.out.println(temp1.isSimultaneousWith(temp2));

		dateTime point11 = new dateTime(0,20,18,12,03,2013);
		dateTime point12 = new dateTime(0,30,18,12,03,2013);

		dateTime point21 = new dateTime(0,30,18,12,03,2013);
		dateTime point22 = new dateTime(0,40,18,12,03,2013);

		dateTime point31 = new dateTime(0,25,18,12,03,2013);
		dateTime point32 = new dateTime(0,35,18,12,03,2013);


		System.out.println(point11.isAfter(point12));
		System.out.println(point11.isBefore(point12));


		dateTime interval1 = new dateTime(point11,point12);
		dateTime interval2 = new dateTime(point21,point22);
		dateTime interval3 = new dateTime(point31,point32);

		System.out.println(interval1.intersects(interval2));
		System.out.println(interval1.intersects(interval3));
		System.out.println(interval2.intersects(interval3));
	}
	
	public void testDataBase() {
		
		//Prøver å legge til 
		Factory f;
			try {
				f = new Factory("./src/db/Properties.properties");
				
				Person p1 = f.getPerson(0);
				Person p2 = f.getPerson(1);
				Person p3 = f.getPerson(2);
				
				Event e1 = new Event(0, null, "Hellige møteplass!", "Drepe!", p1, null);
				Event e2 = new Event(1, null, "Hellige møteplass!", "Drepe!", p1, null);
				Event e3 = new Event(2, null, "Hellige møteplass!", "Drepe!", p1, null);
				Event e4 = new Event(3, null, "Hellige møteplass!", "Drepe!", p1, null);
				Event e5 = new Event(4, null, "Hellige møteplass!", "Drepe!", p1, null);
				Event e6 = new Event(5, null, "Hellige møteplass!", "Drepe!", p1, null);
				Event e7 = new Event(6, null, "Hellige møteplass!", "Drepe!", p1, null);
				
				
			
				
				
				
				
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
