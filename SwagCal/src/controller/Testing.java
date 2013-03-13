package controller;

import gui.ClientGUI;
import gui.ServerGUI;

import java.awt.EventQueue;

import tools.dateTime;

public class Testing {
	
	public static void main(String[] args) {
		testDateTime();
	}

	
	private static void testDateTime(){
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
	
	
	
	
	
	
	
	
}
