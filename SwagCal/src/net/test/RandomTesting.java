package net.test;

import model.Group;
import model.Person;
import net.Capsule;

import com.google.gson.Gson;

import db.DatabaseFactory;

public class RandomTesting {
	
	public static void main(String[] args) {
		Gson gson = new Gson();
//		PersonTest p1 = new PersonTest("per");
//		PersonTest p2 = new PersonTest("tor");
//		
//		 
//		p1.addFriend(p2);
//		System.out.println(p1.friends.get(0).name);
//		 
//		String ps1 = gson.toJson(p1);
//	//	String ps2 = gson.toJson(p2);
//		System.out.println(ps1);
//		
//		randomINt ri = gson.fromJson(ps1, randomINt.class);
//		System.out.println("interface: "+ri);
//		PersonTest p1after = gson.fromJson(ps1, PersonTest.class);
//		System.out.println(p1after.friends.get(0).name);
	//	PersonTest p22 = gson.fromJson(ps2, PersonTest.class);
	//	System.out.println(p12.friends);
		Capsule cap = new Capsule("Message", "INSERT", "Person", false);
		cap.setSendObject(new Person(10, "per", 12345678, "#per", "perword"));
		String toSend = cap.pack();
		System.out.println(toSend);
		
		
		DatabaseFactory df = new DatabaseFactory(toSend);
		System.out.println(df);
		
	}
}
