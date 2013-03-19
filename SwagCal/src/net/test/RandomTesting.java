package net.test;

import model.Group;
import net.Capsule;

import com.google.gson.Gson;

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
		Capsule cap = new Capsule("Group", "INSERT");
		cap.setSendObject(new Group(10, "gruppen"));
		String toSend = cap.pack();
		System.out.println(toSend);
		Capsule cap2 = new Gson().fromJson(toSend, Capsule.class);
		Group g = (Group)cap.getSendObject();
		System.out.println(g);
		
		String toSend2 = cap2.pack();
		System.out.println(toSend2);
	}
}
