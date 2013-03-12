package controller;

import gui.ServerGUI;

import java.awt.EventQueue;

import tools.dateTime;

public class Server {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		//Test
		dateTime pont11 = dateTime();
		dateTime point12 = dateTime();
		
		dateTime point21 = dateTime();
		dateTime point22 = dateTime(); 
		
		dateTime interval1 = new dateTime(point11,point12);
		dateTime interval2 = new dateTime(point21,point22);
		
		
		System.out.println(interval.intersects(interval2));
		
	}
	
}
