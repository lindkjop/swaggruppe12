package net.test;

import model.Person;

import com.google.gson.Gson;

public class RandomTesting {
	
	public static void main(String[] args) {
	 PersonTest p = new PersonTest(new PersonTestName("Per", "Olsen"), new int[5]);
	 Gson gson = new Gson();
	 String pAsString = gson.toJson(p);
	 System.out.println(pAsString);
	 
	 Object o = gson.fromJson(pAsString, Object.class);
	 if (o instanceof String) {
		 System.out.println("STRING!!");
	 }
	 else if (o instanceof PersonTest) {
		 PersonTest p2 = (PersonTest)o;
		 System.out.println(p2.name.getName());	 
	 }
	 else {
		 System.out.println("ELSE");
	 }
	 
	}
}
