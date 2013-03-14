package net.test;

import model.Person;

import com.google.gson.Gson;

public class RandomTesting {
	
	public static void main(String[] args) {
	 Person p = new Person(10, "Per", 47839635, "#Per", "pass123");
	 Gson gson = new Gson();
	 String pAsString = gson.toJson(p);
	 System.out.println(pAsString);
	 
	 Person p2 = gson.fromJson(pAsString, Person.class);
	 System.out.println(p2.getNavn());
	}
}
