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
		
		dateTime now = dateTime.now();
		dateTime soon = new dateTime();
		soon.setDay(13);
		soon.setHour(17);
		soon.setMonth(3);
		soon.setYear(2013);
		soon.setMin(51);
		
		dateTime interval = new dateTime(now,soon);
		
		System.out.println(soon.getHour());
		System.out.println(now.getHour());
		
		System.out.println(interval.getDelta().getHour());
		
	}
	
}
