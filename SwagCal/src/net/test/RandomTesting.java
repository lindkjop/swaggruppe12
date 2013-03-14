package net.test;

import model.Person;

import com.google.gson.Gson;

public class RandomTesting {
	
	public static void main(String[] args) {
	 PersonTest p = new PersonTest(new PersonTestName("Per", "Olsen"), new int[5]);
	 Gson gson = new Gson();
	 String pAsString = gson.toJson(p);
	 System.out.println(pAsString);
	 
	 PersonTest p2 = gson.fromJson(pAsString, PersonTest.class);
	 System.out.println(p2.name);
	 
	}
}
