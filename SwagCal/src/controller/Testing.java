package controller;

import gui.ClientGUI;
import gui.ServerGUI;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

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
				f.addPerson("Daniel", 48923838, "danielso", "Snazzylicious");
				f.addPerson("Gunnar", 48923838, "gunnabo", "jegerteit");
				f.addPerson("Bob", 48923838, "Robertdahl", "ForkortelserFTW");
				f.addPerson("Lise", 48923838, "Lizzmizz", "Jegerjentegamerwtflmfao");
				f.addPerson("Ole", 48923838, "Olliehaug", "Minonkelheterfjell");
				f.addPerson("Frumfleik", 48923838, "Frumf", "Jeghartidenesteitestenavn");
				f.addPerson("Osrælg", 48923838, "Osraelg", "allHailTh33mp3r0r");
				f.addPerson("Høggbob", 48923838, "Bobbærn", "Traktor");
				f.addPerson("Doktor Grev Von Baronen", 48923838, "Vampyrmann", "Blodblodblod");
				f.addPerson("Sneak Bjarnesen", 48923838, "Bjarnesen", "Glaff");
				System.out.println("Alt gikk vel!");
				
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
